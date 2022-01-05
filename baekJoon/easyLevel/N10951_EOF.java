package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

//End Of File 처리 하는 문제
//Scanf의 경우에는 hasNextLine()혹은 hasNextInt() 메서드를 통해 판별.
//BufferedReader의 경우에는 입력 문자열이 null인지 아닌지로 판별.

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
			System.out.println(sb.toString());	// or toString()을 없애도 됨.
		}

	}
}
