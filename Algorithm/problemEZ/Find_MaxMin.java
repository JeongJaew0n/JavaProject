package problemEZ;

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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ��� ���� ����غ���.

		int[] MinMax = FindValue(arrList);

		try {
			for (int i = 0; i < arrList.size(); i++) {
				bw.write(arrList.get(i) + " ");
//				System.out.print(arrList.get(i) + " / ");
			}
			bw.write("\n �ִ밪: " + MinMax[0] + " ��ġ�� " + MinMax[2]);
			bw.write("\n �ּҰ�: " + MinMax[1] + " ��ġ�� " + MinMax[3]);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[] FindValue(ArrayList<Integer> arrList) { // alt+shift+R �ϸ� ���� �ܾ� ��ü ����.

		int max = 0, max_pos = 0; // �ִ밪, �ִ밪 ��ġ
		int min = 0, min_pos = 0; // �ּҰ�, �ּҰ� ��ġ

		if (arrList.size() > 1) { // ã���� �ϴ� �迭���� ���� 1���� ã�� �ʿ䰡 �����Ƿ�

			max = arrList.get(0); // ���� ù ���� ���� �־���. �񱳸� ���� �ִ°�����, �ƹ� ���̵� �������.
			min = max; // � ���̵� ��� ����.

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
			System.out.println("size 2�� �̻�!");
		}

		int[] values = { max, min, max_pos, min_pos };

		return values;
	}

}
