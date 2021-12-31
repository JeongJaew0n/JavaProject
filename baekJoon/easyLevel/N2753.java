package easyLevel;

//������ �־����� ��, �����̸� 1, �ƴϸ� 0�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//������ ������ 4�� ����̸鼭, 100�� ����� �ƴ� �� �Ǵ� 400�� ����� ���̴�.
//���� ���, 2012���� 4�� ����̸鼭 100�� ����� �ƴ϶� �����̴�. 1900���� 100�� ����̰� 400�� ����� �ƴϱ� ������ ������ �ƴϴ�. ������, 2000���� 400�� ����̱� ������ �����̴�.

//�Է�: ù° �ٿ� ������ �־�����. ������ 1���� ũ�ų� ����, 4000���� �۰ų� ���� �ڿ����̴�.
//���: ù° �ٿ� �����̸� 1, �ƴϸ� 0�� ����Ѵ�.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2753 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	//���� �Է� �ޱ� ����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	//���� ��� �ޱ� ����
		int year;
		
		try {
			year = Integer.parseInt(br.readLine());		//�� �� �Է� �ް� int������ ��ȯ
			
			if(year%400 == 0) {		//�켱 400���� �������� ��찡 �ִٸ� ���� ó�� ��.
				bw.write("1");
			}
			else if(year%4==0 && year%100 !=0) {
				bw.write("1");
			}
			
			/*
			 * �� ����� �ڵ�
			 * 
			 * int printInt = 0;
			 * 
			 * if(year%4 == 0) 
			 * 		if(year%100 != 0 || year%400 == 0)
			 * 			printInt = 1;
			 */
			
			else bw.write("0");
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
