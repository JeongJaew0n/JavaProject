import java.util.*;
public class P2 {	//�ǽ�3 ����2��

	public static void main(String[] args) {
		int[] numbers = new int[7];	//�� 7���� ������ �迭
		int save_n = 0;	//�迭�� �����ϱ� ���� ���� �ӽ������� ����
		boolean count = false;	//2��°�� ū���� �����ϴ°� �Ǻ� ������ true, ������ false
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<7; i++) {
			numbers[i] = scan.nextInt();	//�迭�� ���� ����
		}
		
		for(int i=0; i<6; i++) {	// ������������ ����
			for(int j=0; j<6-i; j++) {
				if(numbers[j] < numbers[j+1]) {
					save_n = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = save_n;
				}
			}
		}
		
		for(int i=0; i<6; i++) {
			if(numbers[i] != numbers[i+1]) {	//���� ���� �����ϰ� 2��° ���� ��� �� �ݺ��� ����
				System.out.println(numbers[i+1]);
				count = false;	
				break;
			}
			count = true;
		}
		if(count) {	//2��° ���� ����
			System.out.println("����");
		}
	}

}
