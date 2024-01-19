package players;

public class BasePlayer implements Player {
  private String name;
  private int age;

  private int number;

  private String agentName;

  public BasePlayer(String name, int age, int number) {
    this.name = name;
    this.age = age;
    this.number = number;
  }

  public String getName() { return name; }

  @Override
  public void setAgent(Agent agent) {
    this.agentName = agent.getAgentName();
  }

  public int getAge() { return age; }
  public int getNumber() { return number; }

  @Override
  public void run(int x, int y) {
  }

  @Override
  public void jump() {
  }

  @Override
  public void walk(int x, int y) {
  }

  @Override
  public void ageUp() {
  }

  @Override
  public void showInfo() {
    System.out.println(this);
  }
}
