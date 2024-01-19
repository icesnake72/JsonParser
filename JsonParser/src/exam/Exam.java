package exam;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Exam {
  public static void main(String[] args){
    // 아래와 같이 Scanner를 사용하여 사용자로부터 어떤 정수를 입력받습니다.
//    Scanner scanner = new Scanner(System.in);
//    int num = scanner.nextInt();
//    scanner.close();i
    for(int i=0; i<5; i++) {
      System.out.println("Hello, Java");
    }

    for(int i=1; i<=5; i++) {
      System.out.printf("%3d", i);
    }


    // 1. 1부터 입력받은 정수까지의 합을 구하는 프로그램을 작성하세요.
    // 2. 1부터 입력받은 정수까지의 홀수의 합을 구하는 프로그램을 작성하세요.
    // 3. 1부터 입력받은 정수까지의 짝수의 합을 구하는 프로그램을 작성하세요.
    // 4. 1부터 입력받은 정수까지의 3의 배수의 합을 구하는 프로그램을 작성하세요.

//    for(int i=1; i<=25; i+=5) {
//      for(int j=i; j<=i+4; j++) {
//        System.out.printf("%3d", j);
//      }
//      System.out.println();
//    }

//    try {
//      Scanner sc = new Scanner(System.in);
//      System.out.print("정수를 입력하세요 : ");
//      int num = sc.nextInt();
//      sc.nextLine();
//      sc.close();
//
//      System.out.println("몫 : " + (10/num));
//      System.out.println("나머지 : " + (10 % num));
//    } catch (ArithmeticException e) {
//      System.out.println(e.getMessage());
//    } catch (InputMismatchException e) {
//      System.out.println("정수를 입력해주세요.");
//    } catch (Exception e) {
//      System.out.println("알 수 없는 오류가 발생했습니다.");
//    } finally {
//      System.out.println("프로그램을 종료합니다.");
//    }

//    while(true) {
//
//    }
  }
}
