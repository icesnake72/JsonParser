import java.util.Random;
import java.util.Scanner;

public class Chap02 {

  // Entry Point : 프로그램의 시작점
  public static void main(String[] args) {

    // 문자열의 대입과 출력
    String str = "Hello World";
    System.out.println(str);

    // 문자열의 길이를 length 변수에 대입
    int length = str.length();  // 문자열 객체로부터 길이를 구하는 메소드( length() )
    System.out.printf("Hello World 의 길이 : %d\n", length);

    Scanner scanner = new Scanner(System.in);
    System.out.print("문자열을 입력하세요 : ");
    str = scanner.nextLine(); // 문자열 입력
    scanner.close();

    System.out.printf("입력한 문자열 : %s\n", str);
    System.out.printf("입력한 문자열의 길이 : %d\n", str.length());

    System.out.printf("입력 받은 문자열의 첫번째 문자 : %c\n", str.charAt(0));
    System.out.printf("입력 받은 문자열의 마지막 문자 : %c\n", str.charAt(str.length() - 1));

    // mission 1.
    // 입력 받은 문자열을 모두 세로 방향으로 출력하세요
    // ex) Hello World
    // H
    // e
    // l
    // l
    // o
    //
    // W
    // o
    // r
    // l
    // d

    // mission 2.
    // 입력 받은 문자열을 거꾸로 출력하세요
    // ex) Hello World
    // dlroW olleH





  }
}
