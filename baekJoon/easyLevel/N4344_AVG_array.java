package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4344

/*
 * 주의점 3가지
 * 1.0으로 나눠지는 경우
 * 2.크기가 0인 배열이 선언 되는 것.
 * 3.float과 int 형변환
 */

public class N4344_AVG_array {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {

			int n = Integer.parseInt(br.readLine());
			float[] per = new float[n];		// 비율을 표현하기 위해 float형 배열 선언.

			for (int i = 0; i < n; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());	// 둘째 줄 부터는 한 줄로 입력이 들어 오기 때문에 끊어주기 위해 선언.

				int studentCount = Integer.parseInt(st.nextToken());	// 제일 첫 수는 학생의 수.
					
				per[i] = 0f;	// 비율 배열 초기화 및 학생이 아무도 없을 경우 계산할 필요가 없음.
				
				if (studentCount != 0) {	// 학생의 수가 1명 이상일 경우

					int[] scoreArray = new int[studentCount];
					int count = 0;
					
					int sum = 0;
					int avg = 0;

					for (int j = 0; j < studentCount; j++) {
						scoreArray[j] = Integer.parseInt(st.nextToken());
						sum += scoreArray[j];
					}

					avg = sum / studentCount;

					for (int j = 0; j < studentCount; j++) {
						if (scoreArray[j] > avg)
							count++;
					}

					per[i] = (float) count / studentCount * 100;
				}

			}

			for (int i = 0; i < n; i++) {

				System.out.println(String.format("%.3f%%", per[i]));
			}

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
