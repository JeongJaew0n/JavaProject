package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

//End Of File ó�� �ϴ� ����
//Scanf�� ��쿡�� hasNextLine()Ȥ�� hasNextInt() �޼��带 ���� �Ǻ�.
//BufferedReader�� ��쿡�� �Է� ���ڿ��� null���� �ƴ����� �Ǻ�.

public class N10951_EOF {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int a = 0, b = 0;
		
		try {
			String input;
			while ((input = br.readLine()) != null) {		//input
				StringTokenizer st = new StringTokenizer(input);
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				sb.append((a+b) + "\n");
			}
			
		} catch (IOException | NoSuchElementException e) {
			System.out.println(sb.toString());	// or toString()�� ���ֵ� ��.
		}

	}
}
