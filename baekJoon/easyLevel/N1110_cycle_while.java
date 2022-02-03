package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0���� ũ�ų� ����, 99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�. ���� �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����, �� �ڸ��� ���ڸ� ���Ѵ�. �� ����, 
//�־��� ���� ���� ������ �ڸ� ���� �տ��� ���� ���� ���� ������ �ڸ� ���� �̾� ���̸� ���ο� ���� ���� �� �ִ�. ���� ���� ����.
//26���� �����Ѵ�. 2+6 = 8�̴�. ���ο� ���� 68�̴�. 6+8 = 14�̴�. ���ο� ���� 84�̴�. 8+4 = 12�̴�. ���ο� ���� 42�̴�. 4+2 = 6�̴�. ���ο� ���� 26�̴�.
//���� ���� 4������ ���� ���� ���ƿ� �� �ִ�. ���� 26�� ����Ŭ�� ���̴� 4�̴�.
//N�� �־����� ��, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

//�Է�: ù° �ٿ� N�� �־�����. N�� 0���� ũ�ų� ����, 99���� �۰ų� ���� �����̴�.

//���: ù° �ٿ� N�� ����Ŭ ���̸� ����Ѵ�.

public class N1110_cycle_while {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int cycleCount = 0;

		try {
			if ((input = br.readLine()) != null) { // �Է��� null�� �ƴ� ��� ����.

				int n = Integer.parseInt(input); // �Է¹��� ���� int�� ����ȯ.

				if (!(0 <= n && n <= 99)) // ������ �Է��� 0~99�����̴�. ���� �� ���� ���� ��� ����ó���� ���ش�.
					throw new IOException();

				if (n < 10) { // �̹� ������ 0�̻��̶�� ���� �Ǻ� �����Ƿ� 10���� ������츸 �˻��ϸ� �ȴ�.
					n = n * 10; // 10���� ���� ��� �ڿ� 0�� �ٿ��ش�.
				}

				int originNumber = n; // �ݺ����� ���鼭 n�� �ٲ�� ������ ���� ���ڸ� ����صα� ���� ����.

				while (true) {
					int tenNumber = n / 10; // ���� �ڸ� ��
					int oneNumber = n % 10; // ���� �ڸ� ������
					int newNumber = oneNumber * 10 + (tenNumber + oneNumber) % 10;	//�����ڸ��� ���� �ڸ� ���� ���� �ڸ��� ���ڸ� ���� ��.
					cycleCount++;	//��������Ƿ� ����Ŭ�� �ϳ� �÷��ش�.
					if (newNumber == originNumber) {	
						break;
					}
					n = newNumber;	//���� ���ڰ� �ٸ� ��� ���ο� ���ڸ� �־ �ݺ��� ����.
				}
				System.out.println(cycleCount);
			}
		} catch (IOException e) {	
			System.out.println("0~99������ ���� �Է��� �ּ���!");
		}
	}

}
