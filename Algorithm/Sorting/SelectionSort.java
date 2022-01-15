package Sorting;

import java.util.*;

public class SelectionSort {

    static void selection_sort(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            int minidx = i;                     // i 번째의 요소는 남은 요소들(size - i) 중 가장 작아야함.
//            int min = arr[i];   //이렇게 해도 됨
            
            for (int j = i + 1; j < size; j++) {    //  남은 배열들에 대해서 비교 실행
                if (arr[minidx] > arr[j]) {
                    minidx = j;                     // 가장 작은 원소 발견할때까지
                }
            }
            int temp = arr[minidx];
            arr[minidx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[5005];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        selection_sort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(String.valueOf(arr[i]) + ' ');
        }
    }

}
