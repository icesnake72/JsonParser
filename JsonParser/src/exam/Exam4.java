package exam;

import java.util.Random;

public class Exam4 {
  public static void main(String[] args) {
    // 바이너리 서치 구현
    // int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
    int[] arr = new int[1000000];
    for(int i=0; i<arr.length; i++) {
      arr[i] = i + 1;
    }
    Random rand = new Random();
    int target = rand.nextInt(1000000) + 1;
    System.out.println("target : " + target);

    int count = 0;
    int start = 0;
    int end = arr.length - 1;
    int mid = 0;


    while(start <= end) {
      count++;
      mid = (start + end) / 2;
      if(arr[mid] == target) {
        System.out.println("찾았습니다.");
        break;
      }

      if(arr[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    System.out.println("count : " + count);
  }
}
