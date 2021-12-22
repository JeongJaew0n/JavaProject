package problem1;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Fine_MaxMin {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i=0; i< 10; i++) {
			arrList.add((int)(Math.random()*70));
		}
//		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			for(int i=0; i<arrList.size(); i++) {
				bw.write(arrList.get(i) + " ");
//				System.out.print(arrList.get(i) + " / ");
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] FindMin_Max(ArrayList<Integer> int_arr) {
		int max=0;
		int min=0;
		
		if(int_arr.size() > 1 ) {
			for(int i=1; i<int_arr.size(); i++) {
				
			}
		}
		else {
			System.out.println("size 2°³ ÀÌ»ó!");
		}
		
		int[] values = {max,min};
		
		return values;
	}
	
}
