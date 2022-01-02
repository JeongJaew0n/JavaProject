package middleLevel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//����̴� ���� ��ħ �˶��� ��� �Ͼ��. �˶��� ��� �ٷ� �Ͼ�� �����̰�����, �׻� ���ݸ� �� �ڷ��� ���� ������ ���� �б��� �����ϰ� �ִ�.
//����̴� ��� ����� �����غ�������, ���ݸ� �� �ڷ��� ������ �� � �͵� ���� ���� ������.
//�̷� ����̸� �ҽ��ϰ� ����, â���̴� �ڽ��� ����ϴ� ����� ��õ�� �־���.
//�ٷ� "45�� ���� �˶� �����ϱ�"�̴�.
//�� ����� �ܼ��ϴ�. ���� �����Ǿ� �ִ� �˶��� 45�� �ռ��� �ð����� �ٲٴ� ���̴�. ������ �˶� �Ҹ��� ������, �˶��� ���� ���� �� �� ���̱� �����̴�. �� ����� ����ϸ�, ���� ��ħ �� ��ٴ� ����� ���� �� �ְ�, �б��� �������� �ʰ� �ȴ�.
//���� ����̰� ������ �˶� �ð��� �־����� ��, â������ ����� ����Ѵٸ�, �̸� ������ ���ľ� �ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

//�Է�: ù° �ٿ� �� ���� H�� M�� �־�����. (0 �� H �� 23, 0 �� M �� 59) �׸��� �̰��� ���� ����̰� ������ ���� �˶� �ð� H�� M���� �ǹ��Ѵ�.
//�Է� �ð��� 24�ð� ǥ���� ����Ѵ�. 24�ð� ǥ������ �Ϸ��� ������ 0:0(����)�̰�, ���� 23:59(������ ���� 1�� ��)�̴�. �ð��� ��Ÿ�� ��, ���ʿ��� 0�� ������� �ʴ´�.

//���: ù° �ٿ� ����̰� â������ ����� ����� ��, �����ؾ� �ϴ� �˶� �ð��� ����Ѵ�. (�Է°� ���� ���·� ����ϸ� �ȴ�.)

public class N2884 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	//���� �Է� �ޱ� ����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	//���� ��� �ϱ� ����
		int h,m;
		int a_h = 0, a_m = 0;
		boolean carry = false;
		String input;
		
		try {
			input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);	//�Է� ���� ���� ���� ������ ���� ����.
			h = Integer.parseInt(st.nextToken());				
			m = Integer.parseInt(st.nextToken());
			
			if(m < 45) {
				carry = true;
				a_m = (60+m)-45;
			}
			else a_m = m-45;
			
			if(carry) {
				if(h==0) a_h=23;
				else a_h = h-1;
			}
			else a_h = h;
			
			bw.write(a_h + " " + a_m);
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
