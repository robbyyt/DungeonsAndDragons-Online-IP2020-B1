package Server;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ServerControllers.*;

public class ProtocolHandler {
    //TAKES THE DATA AND PICKS A PROTOCOL ACCORDINGLY
    //returns a number for each protocol detected
    public int parse(JSONObject object){
        String protocol =  object.get("PROTOCOL").toString();
        System.out.println(object);
        if(protocol.compareTo("CREATE_LOBBY")==0){
            return 1;
        }
        else if(protocol.compareTo("JOIN_LOBBY")==0){
            return 2;
        }
        else if(protocol.compareTo("SHOW_LOBBIES")==0)
        {
            return 3;
        }
        return 0;
    }
    public JSONObject response(JSONObject object){
        JSONObject response = new JSONObject();
        int n = parse(object);
            if (n == 1) {
                return new CreateLobby().createLobby(object);
            } else if (n == 2) {
                return new JoinLobby().joinLobby(object);

            } else if (n == 3) {
                return new ShowLobbies().showLobbies(object);
            }
            return new Unkown().unknown();
        }
    }
/*
    public JSONObject createRoom(JSONObject object){
        String name = object.get("ROOM_NAME").toString();
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","CREATE_ROOM");
        boolean uniqName= true;

        for(Room r : serverRooms.getRoomList())
        {
            System.out.println(r.getName());
            if(r.getName().compareTo(name)==0){
                uniqName= false;
                break;
            }
        }
        System.out.println(uniqName);
        if(uniqName) {
            int roomId = serverRooms.getRoomList().size();
            Room r = new Room(roomId + 1, name);
            serverRooms.addRoom(r);
            json.put("ROOM_ID", roomId);
            json.put("ROOM_NAME", name);
            json.put("ANSWER", "Room succesfully created");
            json.put("SUCCESS", 1);
        }
        else{
            json.put("ANSWER","Already existing room");
            json.put("SUCCESS",0);
        }
        return  json;
    }

    public JSONObject joinRoom(JSONObject object){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","JOIN_ROOM");
        //int userId = Integer.getInteger(object.get("ROOM_ID").toString());
        String roomName = object.get("ROOM_NAME").toString();
        boolean findRoom = false;
        for(Room r : serverRooms.getRoomList()){
            if(r.getName().compareTo(roomName)==0)
            {
                findRoom = true;
                break;
            }
        }

        if(findRoom){
            json.put("SUCCESS",1);
            json.put("ANSWER","JOINED");
        }
        else{
            json.put("SUCCESS",0);
            json.put("ANSWER","COULDN'T FIND ROOM");
        }

        return json;
    }
    public JSONObject showRooms(JSONObject object){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SHOW_ROOMS");
        int nrRooms = serverRooms.getRoomList().size();
        json.put("NR_ROOMS",nrRooms);
        JSONArray jsonArray = new JSONArray();
        for(Room r : serverRooms.getRoomList()){
            JSONObject roomProp = new JSONObject();
            roomProp.put("ID",r.getId());
            roomProp.put("NAME",r.getName());
            roomProp.put("NR_PLAYERS",r.getPlayerList().size());
            jsonArray.add(roomProp);
        }
        json.put("LIST_ROOMS",jsonArray);
        json.put("SUCCESS",1);
        return json ;
    }*/
