package sorting;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();      
        
        int[] d = new int[5005];    // 임의의 크기
        
        for (int i = 0; i < n; i++)     // n 개의 int 형 데이터
            d[i] = scanner.nextInt();   // 입력 받음

        for (int i = 0; i < n; i++) {
            int temp = d[i];            //  i는 정렬된 영역에 들어가기 위해 비교될 요소
            int j = i - 1;              //  j는 이미 정렬된 영역의 범위임

            for (; j >= 0; j--) {       // j를 만큼 실행
                if (d[j] < temp)        // temp, 즉 정렬된 부분이 현재 원소보다 크다면 멈춤-> 오름차순 정렬.
                    break;
                d[j + 1] = d[j];
            }

            d[j + 1] = temp;            // d[j+1] 까지는 정렬 안료됨.
        }

        for (int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
    }
}
	