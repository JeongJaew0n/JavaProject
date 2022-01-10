package easyLevel;

public class N4673_FindNotSelfNumber {

	public static void main(String[] args) {
		
		int arraySize = 10000;
		int[] check = new int[arraySize];
		
		for(int i=1; i<arraySize; i++ ) {
			int number = d(i);
			if(number < 10000) {
				check[number] = number;
			}
			if(check[i] == 0)
				System.out.println(i);
		}

	}
	
	public static int d(int constructor) {
		String conString = String.valueOf(constructor);
		int newNumber = constructor;
		for( int i=0; i<conString.length(); i++) {
			newNumber += conString.charAt(i) - '0';
		}
		
		return newNumber;
	}
}
