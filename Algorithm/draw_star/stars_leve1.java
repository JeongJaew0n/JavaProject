package draw_star;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class dia {
	void draw(int n) {
		System.out.println("drawing...");
		char[] data = new char[n];
		for(int i=0; i<n; i++) {
			data[i] = ' ';
		}
		for(int i=0; i<n/2+1; i++) {
			data[n/2 + i] = '*';
			data[n/2 - i] = '*';
			System.out.println(data);
		}
		for(int i=n/2; i>0; i--) {
			data[n/2 + i] = ' ';
			data[n/2 - i] = ' ';
			System.out.println(data);
		}
	}
}

public class stars_leve1{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dia d = new dia();
		
		System.out.print("Input number: ");
		
		String s = br.readLine();
		br.close();
		int num = Integer.parseInt(s);

		System.out.println(num);
		
		d.draw(num);

	}

}
