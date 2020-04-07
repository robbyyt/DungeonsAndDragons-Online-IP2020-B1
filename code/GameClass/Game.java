import java.sql.Connection;
import java.sql.SQLException;

public class Game {
  protected List<User> users;
  protected int turnNo;
  protected DatabaseConnection db;
  protected DungeonMaster dm;
  protected OutcomeTurn outcome;
  protected PlayerInput playerInput;
  protected int socket;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public int getTurnNo() {
    return turnNo;
  }

  public void setTurnNo(int turnNo) {
    this.turnNo = turnNo;
  }

  public DungeonMaster getDm() {
    return dm;
  }

  public void setDm(DungeonMaster dm) {
    this.dm = dm;
  }

  public OutcomeTurn getOutcome() {
    return outcome;
  }

  public void setOutcome(OutcomeTurn outcome) {
    this.outcome = outcome;
  }

  public PlayerInput getPlayerInput() {
    return playerInput;
  }

  public void setPlayerInput(PlayerInput playerInput) {
    this.playerInput = playerInput;
  }

  public void newTurn() {}

  public void init(DatabaseConnection db, int socket) {}

  public void sendOutcome(int socket) {}

  @Override
  public String toString() {
    return "Game{"
        + "users="
        + users
        + ", turnNo="
        + turnNo
        + ", db="
        + db
        + ", dm="
        + dm
        + ", outcome="
        + outcome
        + ", playerInput="
        + playerInput
        + ", socket="
        + socket
        + '}';
  }
}
