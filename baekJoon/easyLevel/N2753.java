package easyLevel;

//연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
//윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
//예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다. 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다. 하지만, 2000년은 400의 배수이기 때문에 윤년이다.

//입력: 첫째 줄에 연도가 주어진다. 연도는 1보다 크거나 같고, 4000보다 작거나 같은 자연수이다.
//출력: 첫째 줄에 윤년이면 1, 아니면 0을 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2753 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	//숫자 입력 받기 위해
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	//숫자 출력 받기 위해
		int year;
		
		try {
			year = Integer.parseInt(br.readLine());		//한 줄 입력 받고 int형으로 변환
			
			if(year%400 == 0) {		//우선 400으로 나눠지는 경우가 있다면 먼저 처리 됨.
				bw.write("1");
			}
			else if(year%4==0 && year%100 !=0) {
				bw.write("1");
			}
			
			/*
			 * 더 깔끔한 코드
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
