package players;

public interface Player extends Athletic, Person {

  public void showInfo();
  public String getName();

  public void setAgent(Agent agent);

}
