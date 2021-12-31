package easyLevel;

import java.util.Scanner;

public class N23303 {
	
	public static void main(String[] args) {
		
		String user_input;
		
		Scanner sc = new Scanner(System.in);
		user_input = sc.nextLine();
		
		if(user_input.contains("d2") || user_input.contains("D2")) {
			System.out.println("D2");
		}
		else {
			System.out.println("unrated");
		}
	}

}
