package exam;

import java.util.Scanner;

public class Exam2 {
  public static void main(String[] args) {
    // 아래와 같이 Scanner를 사용하여 사용자로부터 어떤 정수를 입력받습니다.
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    sc.nextLine();
    sc.close();

    for(int i=1; i>=num; i++) {
      System.out.printf("%3d", i);
      if(i % 5 == 0) {
        System.out.println();
      }
    }

    num = 10;
    for (int i=0; i < 10; i++) {
      System.out.println("10보다 작습니다.");
    }

  }
}
