package players;

import java.util.ArrayList;

public class PlayerAgent implements Agent{

  private String agentName;

  private final ArrayList<Player> players = new ArrayList<Player>();

  public PlayerAgent(String agentName) {
    this.agentName = agentName;
  }


  public void addPlayer(Player player) {
    players.add(player);
    player.setAgent(this);
  }

  public void showPlayers() {
    for (Player player : players) {
      player.showInfo();
    }
  }

  public void sign(PlayerSign playerSign) {
    for (Player player : players) {
      playerSign.sign(player);
    }
  }

  @Override
  public String getAgentName() {
    return agentName;
  }
}
