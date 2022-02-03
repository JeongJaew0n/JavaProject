package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 그 다음, 
//주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
//26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
//위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
//N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.

//입력: 첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.

//출력: 첫째 줄에 N의 사이클 길이를 출력한다.

public class N1110_cycle_while {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int cycleCount = 0;

		try {
			if ((input = br.readLine()) != null) { // 입력이 null이 아닐 경우 실행.

				int n = Integer.parseInt(input); // 입력받은 값을 int로 형변환.

				if (!(0 <= n && n <= 99)) // 문제의 입력이 0~99까지이다. 따라서 이 외의 값일 경우 예외처리를 해준다.
					throw new IOException();

				if (n < 10) { // 이미 위에서 0이상이라는 것을 판별 했으므로 10보다 작을경우만 검사하면 된다.
					n = n * 10; // 10보다 작을 경우 뒤에 0을 붙여준다.
				}

				int originNumber = n; // 반복문을 돌면서 n이 바뀌기 때문에 원래 숫자를 기억해두기 위한 변수.

				while (true) {
					int tenNumber = n / 10; // 십의 자리 몫
					int oneNumber = n % 10; // 일의 자리 나머지
					int newNumber = oneNumber * 10 + (tenNumber + oneNumber) % 10;	//십의자리는 일의 자리 수고 일의 자리는 각자리 수의 합.
					cycleCount++;	//계산했으므로 사이클을 하나 늘려준다.
					if (newNumber == originNumber) {	
						break;
					}
					n = newNumber;	//만약 숫자가 다를 경우 새로운 숫자를 넣어서 반복문 진행.
				}
				System.out.println(cycleCount);
			}
		} catch (IOException e) {	
			System.out.println("0~99사이의 값을 입력해 주세요!");
		}
	}

}
