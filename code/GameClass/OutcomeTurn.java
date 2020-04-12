package GameClass;

import User.User;

import java.util.Arrays;
import java.util.List;

public class OutcomeTurn {
  protected List<User> players;
  protected OutcomeTurn[] outcome;

  public OutcomeTurn() {}

  public List<User> getPlayers() {
    return players;
  }

  public void setPlayers(List<User> players) {
    this.players = players;
  }

  public OutcomeTurn[] getOutcome() {
    return outcome;
  }

  public void setOutcome(OutcomeTurn[] outcome) {
    this.outcome = outcome;
  }

  @Override
  public String toString() {
    return "OutcomeTurn{" + "players=" + players + ", outcome=" + Arrays.toString(outcome) + '}';
  }
}
