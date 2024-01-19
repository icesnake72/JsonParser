package exam;

import java.util.Arrays;
import java.util.Random;

public class Exam3 {
  public static void main(String[] args) {
    // 버블 소트 만들기
    int[] arr = new int[6];
    Random rand = new Random();
    for(int i=0; i<arr.length; i++) {
      arr[i] = rand.nextInt(45) + 1;
    }

    int temp = 0;
    System.out.println("버블 정렬 전");
    System.out.println(Arrays.toString(arr));

    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j - 1] > arr[j]) {
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
      System.out.println(Arrays.toString(arr));
    }

    System.out.println("버블 정렬 후");
    System.out.println(Arrays.toString(arr));
  }
}
