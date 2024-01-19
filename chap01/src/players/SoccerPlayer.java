package players;

public class SoccerPlayer extends BasePlayer{
  public SoccerPlayer(String name, int age, int number) {
    super(name, age, number);
  }

  @Override
  public String toString() {
    return String.format("축구 선수 : %s(%d), %d살", getName(), getNumber(), getAge());
  }

  public void kickTheBall() {
    System.out.printf("%s가 공을 찼습니다!\n", getName());
  }
}
