package problem1;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Find_MaxMin {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arrList.add((int) (Math.random() * 70));
		}
//		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 버퍼 사용해보기.

		int[] MinMax = FindValue(arrList);

		try {
			for (int i = 0; i < arrList.size(); i++) {
				bw.write(arrList.get(i) + " ");
//				System.out.print(arrList.get(i) + " / ");
			}
			bw.write("\n 최대값: " + MinMax[0] + " 위치는 " + MinMax[2]);
			bw.write("\n 최소값: " + MinMax[1] + " 위치는 " + MinMax[3]);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[] FindValue(ArrayList<Integer> arrList) { // alt+shift+R 하면 같은 단어 전체 선택.

		int max = 0, max_pos = 0; // 최대값, 최대값 위치
		int min = 0, min_pos = 0; // 최소값, 최소값 위치

		if (arrList.size() > 1) { // 찾고자 하는 배열에서 값이 1개면 찾을 필요가 없으므로

			max = arrList.get(0); // 제일 첫 번재 값을 넣어줌. 비교를 위해 넣는것으로, 아무 값이든 상관없음.
			min = max; // 어떤 값이든 상관 없음.

			for (int i = 1; i < arrList.size(); i++) {
				if (max < arrList.get(i)) {
					max = arrList.get(i);
					max_pos = i + 1;
				}
				if (min > arrList.get(i)) {
					min = arrList.get(i);
					min_pos = i + 1;
				}
			}
		} else {
			System.out.println("size 2개 이상!");
		}

		int[] values = { max, min, max_pos, min_pos };

		return values;
	}

}
