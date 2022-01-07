package middleLevel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1을 첫 수로 봤을 때 짝수는 내려가고 홀수는 올라갑니다.

public class N1193_easyMath {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int x = Integer.parseInt(br.readLine());
			int n = 0;
			int sum = 0;
			int order = 0;

			while(true) {
				
				sum = sum + (n + 1);	//수열
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
