package middleLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���丮��5��, N!�� 0�� �ƴ� �� 5�ڸ��� ���Ѵ�.
//N�� �־����� ��, ���丮��5�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

//�Է�
//ù° �ٿ� ���� N�� �־�����. N�� 1,000,000���� �۰ų� ����. ��, 9���� ũ�ų� ����.

//���
//ù° �ٿ� N�� ���丮��5�� ����Ѵ�.

public class N1564 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number;
		try {
			number = Integer.parseInt(br.readLine());
			br.close();
			long facN = facT((long)number);

			System.out.println(String.format("%05d", facN));
			System.out.println((long)Math.pow(10, 12));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static long factorial(int n) {	//����Լ� ���丮��
		if(n == 1) {
			return 1;
		}
		return n * factorial(n-1) % 10000000;	
		//7�ڸ��� ���� ��� 6�ڸ��� ������. �̷� ��� 10���� ������ 5�ڸ����� ������ �ȴ�.
		
		//n�ڸ� ���� * m�ڸ� ���� �� ���� ��� ����� �ִ� n+m�ڸ� ���ڰ� �Ǵµ�
		//n��m�� ���� �ڸ��� -1�� �� ������ ���� ������ �ȴ�.
		//���� ��� 223 * 3896�� ����� 868,808�̰� 623 * 9596�� 5,978,308�̴�. 
		//08, �� 2�ڸ� ������ ���� �����ϴ�. ���⼭ 223,623�� 3�ڸ� �̹Ƿ� 2�ڸ� ������ ���� �����ȴ�.
	}
	
	public static long facT(long n) {		//����Լ� �Ⱦ� ���丮��
		long fac5 = 1;
		if(n==1) {
			return 1;
		}
		for(int i = 2; i<=n; i++) {
			fac5 = fac5 * i;
			while(fac5%10 == 0) {
				fac5 = fac5/10;
			}
			fac5 = fac5 % (long)Math.pow(10, 7);
		}

		long facInt = fac5 % (long)Math.pow(10, 5);
		
		return facInt;
	}
	
}

/*������
 *fac5 = fac5 *i
 *fac5 = fac5 % 1000000000000L; (0�� 12��)
 *�� �����
 *fac5 = (fac5 * i) fac5 % 1000000000000L�� ����� �ٸ���!
 *
 *pow(10,7)���ε� ����� 5�ڸ� ���� ��Ȯ�� �����µ� �� ������ 12�� �ؾ� �����ϱ�??????????????
 */
