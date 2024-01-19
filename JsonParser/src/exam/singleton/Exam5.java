package exam.singleton;

public class Exam5 {
  public static void main(String[] args) {
    // singleton 패턴
    // 1. 생성자를 private으로 만든다.
    // 2. 자기 자신의 인스턴스를 생성한다.
    // 3. 자기 자신의 인스턴스를 리턴하는 메소드를 만든다.
    // 4. 자기 자신의 인스턴스를 담을 변수를 만든다.
    // 5. 자기 자신의 인스턴스를 생성하는 메소드를 만든다.

    for(int i=0; i<10; i++) {
      AppManager appManager = AppManager.getInstance();
      appManager.setAppData("앱 데이터 " + i);
      System.out.println(appManager.getAppData());
    }
  }
}
