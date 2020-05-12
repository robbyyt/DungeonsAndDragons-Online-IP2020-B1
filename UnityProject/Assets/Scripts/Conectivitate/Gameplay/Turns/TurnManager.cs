using System.Collections;
using System.Collections.Generic;
using Photon.Pun;
using Photon.Realtime;
using UnityEngine;
using ExitGames.Client.Photon;
using Photon.Pun.UtilityScripts;
using Hashtable = ExitGames.Client.Photon.Hashtable;

namespace DefaultNamespace
{
    public class TurnManager : MonoBehaviourPunCallbacks, IOnEventCallback
    {
        Player sender;

        //turn index
        public int Turn
        {
            get { return PhotonNetwork.CurrentRoom.GetTurn(); }
            private set
            {
                _isOverCallProcessed = false;

                PhotonNetwork.CurrentRoom.SetTurn(value, true);
            }
        }

        // The duration of the turn in seconds.
        public float TurnDuration = 50f;

        // Gets the elapsed time in the current turn in seconds
        public float ElapsedTimeInTurn
        {
            get
            {
                return ((float) (PhotonNetwork.ServerTimestamp - PhotonNetwork.CurrentRoom.GetTurnStart())) / 1000.0f;
            }
        }


        // Gets the remaining seconds for the current turn. Ranges from 0 to TurnDuration
        public float RemainingSecondsInTurn
        {
            get { return Mathf.Max(0f, this.TurnDuration - this.ElapsedTimeInTurn); }
        }


        // Gets a value indicating whether the turn is completed by all.
        public bool IsCompletedByAll
        {
            get
            {
                return PhotonNetwork.CurrentRoom != null && Turn > 0 &&
                       this.finishedPlayers.Count == PhotonNetwork.CurrentRoom.PlayerCount;
            }
        }


        // Gets a value indicating whether the current turn is finished by me.
        public bool IsFinishedByMe
        {
            get { return this.finishedPlayers.Contains(PhotonNetwork.LocalPlayer); }
        }


        // Gets a value to check if the turn is over.
        public bool IsOver
        {
            get { return this.RemainingSecondsInTurn <= 0f; }
        }


        // The turn manager listener. Need tp set this to another script to catch The callbacks TODO
        public IPunTurnManagerCallbacks TurnManagerListener;


        // The finished players.
        private readonly HashSet<Player> finishedPlayers = new HashSet<Player>();

        // The turn manager event offset event message byte. Used internaly for defining data in Room Custom Properties
        public const byte TurnManagerEventOffset = 0;

        // The Move event message byte. Used internaly for saving data in Room Custom Properties

        public const byte EvMove = 1 + TurnManagerEventOffset;


        // The Final Move event message byte. Used internaly for saving data in Room Custom Properties
        public const byte EvFinalMove = 2 + TurnManagerEventOffset;

        // keep track of message calls
        private bool _isOverCallProcessed = false;

        #region MonoBehaviour CallBack

        void Start()
        {
        }

        void Update()
        {
            if (Turn > 0 && this.IsOver && !_isOverCallProcessed)
            {
                _isOverCallProcessed = true;
                this.TurnManagerListener.OnTurnTimeEnds(this.Turn);
            }
        }

        #endregion


        // Tells the TurnManager to begin a new turn.
        public void BeginTurn()
        {
            Turn = this.Turn +
                   1; // note: this will set a property in the room, which is available to the other players.
        }


        // Call to send an action. Optionally finish the turn, too.
        // Need too define the move object TODO

        public void SendMove(object move, bool finished)
        {
            if (IsFinishedByMe)
            {
                UnityEngine.Debug.LogWarning("Can't SendMove. Turn is finished by this player.");
                return;
            }

            // along with the actual move, we have to send which turn this move belongs to
            Hashtable moveHt = new Hashtable();
            moveHt.Add("turn", Turn);
            moveHt.Add("move", move);

            byte evCode = (finished) ? EvFinalMove : EvMove;
            PhotonNetwork.RaiseEvent(evCode, moveHt,
                new RaiseEventOptions() {CachingOption = EventCaching.AddToRoomCache},
                SendOptions.SendReliable);
            if (finished)
            {
                PhotonNetwork.LocalPlayer.SetFinishedTurn(Turn);
            }

            ProcessOnEvent(evCode, moveHt, PhotonNetwork.LocalPlayer.ActorNumber);
        }

        // Gets if a player finished the current turn.

        public bool GetPlayerFinishedTurn(Player player)
        {
            if (player != null && this.finishedPlayers != null && this.finishedPlayers.Contains(player))
            {
                return true;
            }

            return false;
        }

        #region Callbacks

        // called internally
        void ProcessOnEvent(byte eventCode, object content, int senderId)
        {
            if (senderId == -1)
            {
                return;
            }

            sender = PhotonNetwork.CurrentRoom.GetPlayer(senderId);

            switch (eventCode)
            {
                case EvMove:
                {
                    Hashtable evTable = content as Hashtable;
                    int turn = (int) evTable["turn"];
                    object move = evTable["move"];
                    this.TurnManagerListener.OnPlayerMove(sender, turn, move);

                    break;
                }
                case EvFinalMove:
                {
                    Hashtable evTable = content as Hashtable;
                    int turn = (int) evTable["turn"];
                    object move = evTable["move"];

                    if (turn == this.Turn)
                    {
                        this.finishedPlayers.Add(sender);

                        this.TurnManagerListener.OnPlayerFinished(sender, turn, move);
                    }

                    if (IsCompletedByAll)
                    {
                        this.TurnManagerListener.OnTurnCompleted(this.Turn);
                    }

                    break;
                }
            }
        }

        public void OnEvent(EventData photonEvent)
        {
            this.ProcessOnEvent(photonEvent.Code, photonEvent.CustomData, photonEvent.Sender);
        }

        public override void OnRoomPropertiesUpdate(Hashtable propertiesThatChanged)
        {
            //   Debug.Log("OnRoomPropertiesUpdate: "+propertiesThatChanged.ToStringFull());

            if (propertiesThatChanged.ContainsKey("Turn"))
            {
                _isOverCallProcessed = false;
                this.finishedPlayers.Clear();
                this.TurnManagerListener.OnTurnBegins(this.Turn);
            }
        }

        #endregion
    }

    public static class TurnExtensions
    {
        
        /// currently ongoing turn number
        public static readonly string TurnPropKey = "Turn";


        // start (server) time for currently ongoing turn (used to calculate end)
        public static readonly string TurnStartPropKey = "TStart";
        
        // Finished Turn of Actor (followed by number)
        public static readonly string FinishedTurnPropKey = "FToA";
        
        
        // Sets the turn
        public static void SetTurn(this Room room, int turn, bool setStartTime = false)
        {
            if (room == null || room.CustomProperties == null)
            {
                return;
            }

            Hashtable turnProps = new Hashtable();
            turnProps[TurnPropKey] = turn;
            if (setStartTime)
            {
                turnProps[TurnStartPropKey] = PhotonNetwork.ServerTimestamp;
            }

            room.SetCustomProperties(turnProps);
        }
        
        // Gets the current turn from a RoomInfo
        public static int GetTurn(this RoomInfo room)
        {
            if (room == null || room.CustomProperties == null || !room.CustomProperties.ContainsKey(TurnPropKey))
            {
                return 0;
            }

            return (int) room.CustomProperties[TurnPropKey];
        }


 
        // Returns the start time when the turn began. This can be used to calculate how long it's going on.
        public static int GetTurnStart(this RoomInfo room)
        {
            if (room == null || room.CustomProperties == null || !room.CustomProperties.ContainsKey(TurnStartPropKey))
            {
                return 0;
            }
            return (int) room.CustomProperties[TurnStartPropKey];
        }
        
        
        // Gets the player's finished turn (from the ROOM properties)
        public static int GetFinishedTurn(this Player player)
        {
            Room room = PhotonNetwork.CurrentRoom;
            if (room == null || room.CustomProperties == null || !room.CustomProperties.ContainsKey(TurnPropKey))
            {
                return 0;
            }

            string propKey = FinishedTurnPropKey + player.ActorNumber;
            return (int) room.CustomProperties[propKey];
        }


        // Sets the player's finished turn (in the ROOM properties)
        public static void SetFinishedTurn(this Player player, int turn)
        {
            Room room = PhotonNetwork.CurrentRoom;
            if (room == null || room.CustomProperties == null)
            {
                return;
            }

            string propKey = FinishedTurnPropKey + player.ActorNumber;
            Hashtable finishedTurnProp = new Hashtable();
            finishedTurnProp[propKey] = turn;

            room.SetCustomProperties(finishedTurnProp);
        }
    }
}