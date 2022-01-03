package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//���� N���� �̷���� ���� A�� ���� X�� �־�����. �̶�, A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

//�Է�: ù° �ٿ� N�� X�� �־�����. (1 �� N, X �� 10,000)
//��° �ٿ� ���� A�� �̷�� ���� N���� �־�����. �־����� ������ ��� 1���� ũ�ų� ����, 10,000���� �۰ų� ���� �����̴�.

//���: X���� ���� ���� �Է¹��� ������� �������� ������ ����Ѵ�. X���� ���� ���� ��� �ϳ� �����Ѵ�.

public class N10871_findSmall {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//������ ���� N
			int X = Integer.parseInt(st.nextToken());	//���� ���� ã�� ������ �Ǵ� �� X
			
			int[] arr = new int[N];		//N������ ������ ������ �迭
			ArrayList<Integer> smaller = new ArrayList<>();	//���� ���� ã���� �� �����ϱ� ���� ArrayList
			//�� ����: ���� ���� ���� �� ���� ������ �𸣱� ������ �ּ� N�� ���� ũ���� �迭�� ��������� �Ѵ�. �̷��� ���ʿ��� �޸𸮸� �Ҵ���� �� �ִ�.
			
			StringTokenizer input_arr = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(input_arr.nextToken());
				if(arr[i] < X) {
					smaller.add(arr[i]);
				}
			}
			for(int i=0; i<smaller.size(); i++) {
				System.out.print(smaller.get(i));
				if(i!=smaller.size()-1) System.out.print(" ");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
