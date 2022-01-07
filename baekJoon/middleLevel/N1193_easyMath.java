package middleLevel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1�� ù ���� ���� �� ¦���� �������� Ȧ���� �ö󰩴ϴ�.

// 1 3 6 10 15 ... ���� ���� 1�� ���� �ϴ� �����̴�.
// ������ ��Ÿ���� ������ a(n) = a(n-1) + n�̴�.

/* ���� Ǯ�� �˰���
	1. x�� �� ��° �밢���� �ִ��� ���Ѵ�.
		- x���� n��° ���Ҹ� ���� �� 0�̰ų� �������, x�� n+1��° index�� �ִ� ���̴�. �ݺ����� 0���� �����ϴ� n+1 ��°�� �ϰڴ�.
	2. index��ȣ�� Ȧ���� �밢�� �Ʒ����� ���� �ö󰡴� ����(���ڰ� �۾����� �и� Ŀ��)�̰�
		¦���� �밢�� ���������� �������� ����(���ڰ� Ŀ���� �и� �۾���)�̴�. 
	���� ��� �������ڸ�, 4�� ��쿡�� 4-6�� ���� �� -2, �� ������ �����Ƿ� 3��° �ٿ� �ִ�.(1 3 6 ...)
	�׸��� 3��°��� Ȧ���̰� Ȧ���� �ö󰡴� ����, �� ���ڰ� �۾����� �и� Ŀ���� �ȴ�. 
	3��° ���� ������ ���ڰ� ���� ū ������ 3/1���� �����ؼ� 2/2 1/3 �̷� �����̴�.
	�׸��� *3��° �밢���� ��� �� 3���� ��Ҹ� �������ִ�.* <- �߿��ϴ�.
	�տ��� ���⸦ ���� �� ���� 0�� ������ ���ڰ� �ִٸ� �ش� ���ڰ� �ش� �밢���� ���� �����̴�. (����: 6)
	�׷��� -2��� ���� 0���� ������ 3��° ��Ҷ�� ���� ����!
	��, x=4�� ��쿡�� �밢���� ���� �ִٴ� �Ҹ��̰�, �ٽ� �������� Ȧ���� ��쿡�� ���ڰ� �۾����� �и� Ŀ���µ� 
	�׷��ٴ� ���� Ȧ�� => ���� = �������� , �и� = ��������
	�׷��� 4�� �� ���� �ִ� ���ڴϱ� ���� ���� ���� ���� �׸��� ���� ū �и� ������
	���� 3/1 �̴�.
*/

public class N1193_easyMath {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int x = Integer.parseInt(br.readLine());
			int n = 0;	// n ��°
			int sum = 0;
			int order = 0;

			while(true) {
				
				sum = sum + (n + 1);	// ��� ���� ��.
				order = x - sum;
				if(order <= 0 ) {
					break;
				}
				n++;
				
			}
			
			order *= -1;
			
			if((n+1)%2 == 1) {
				System.out.println((order+1) + "/" + ((n+1) - order));
			}
			else {
				System.out.println(((n+1) - order) + "/" + (order+1));
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
