package players;

public class BaseballPlayer extends BasePlayer {
  public BaseballPlayer(String name, int age, int number) {
    super(name, age, number);
  }

  @Override
  public String toString() {
    return String.format("야구 선수 : %s(%d), %d살", getName(), getNumber(), getAge());
  }

  public void hitTheBall() {
    System.out.printf("%s가 공을 쳤습니다!\n", getName());
  }

}
