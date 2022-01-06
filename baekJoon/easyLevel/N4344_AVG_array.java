package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4344

/*
 * ������ 3����
 * 1.0���� �������� ���
 * 2.ũ�Ⱑ 0�� �迭�� ���� �Ǵ� ��.
 * 3.float�� int ����ȯ
 */

public class N4344_AVG_array {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {

			int n = Integer.parseInt(br.readLine());
			float[] per = new float[n];		// ������ ǥ���ϱ� ���� float�� �迭 ����.

			for (int i = 0; i < n; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());	// ��° �� ���ʹ� �� �ٷ� �Է��� ��� ���� ������ �����ֱ� ���� ����.

				int studentCount = Integer.parseInt(st.nextToken());	// ���� ù ���� �л��� ��.
					
				per[i] = 0f;	// ���� �迭 �ʱ�ȭ �� �л��� �ƹ��� ���� ��� ����� �ʿ䰡 ����.
				
				if (studentCount != 0) {	// �л��� ���� 1�� �̻��� ���

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
