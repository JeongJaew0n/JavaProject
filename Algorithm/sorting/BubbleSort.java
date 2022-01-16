package sorting;

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] d = new int[5005];

        for (int i = 0; i < n; i++)
            d[i] = scanner.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++)     // 오름차순이므로 i가 한번 실행 될때마다 오른쪽부터 정렬 완료된 영역이 채워진다.
                if (d[j] > d[j + 1]) {
                    int temp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = temp;
                }

        for (int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
    }
}
