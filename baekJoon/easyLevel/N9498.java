package easyLevel;

import java.util.Scanner;

//���� ������ �Է¹޾� 90 ~ 100���� A, 80 ~ 89���� B, 70 ~ 79���� C, 60 ~ 69���� D, ������ ������ F�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//�Է�: ù° �ٿ� ���� ������ �־�����. ���� ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.
//���: ���� ������ ����Ѵ�.

public class N9498 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		if(100>= score && score >= 90) {
			System.out.println("A");
		}
		else if(89 >= score && score >= 80 ) {
			System.out.println("B");
		}
		else if(79 >= score && score >= 70) {
			System.out.println("C");
		}
		else if(69 >= score && score >= 60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
	}
}