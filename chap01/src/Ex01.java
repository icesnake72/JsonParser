import players.*;

public class Ex01 {
  public static void main(String[] args) {
    PlayerAgent agent = new PlayerAgent("플레이어 에이전트");

    BasePlayer player1 = new BaseballPlayer("홍길동", 20, 18);
    BasePlayer player2 = new SoccerPlayer("김철수", 21, 19);

    agent.addPlayer(player1);
    agent.addPlayer(player2);
    agent.addPlayer(new BaseballPlayer("이영희", 22, 20));
    agent.addPlayer(new Player() {
      private String agentName;
      @Override
      public void showInfo() {
        System.out.println(this);
      }

      @Override
      public String getName() {
        return "김영수";
      }

      @Override
      public void setAgent(Agent agent) {
        this.agentName = agent.getAgentName();
      }

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
      public String toString() {
        return "구슬치기 선수: 김영수(21), 20살";
      }
    });

    agent.showPlayers();
    agent.sign(player -> {
      System.out.printf("%s가 계약을 했습니다!\n", player.getName());
    });

  }
}
