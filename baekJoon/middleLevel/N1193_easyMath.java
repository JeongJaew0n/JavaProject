package middleLevel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//.
// 1 3 6 10 15 ... 같이 차가 1씩 증가 하는 수열이다.
// 식으로 나타내면 수열의 a(n) = a(n-1) + n이다.

/* 나의 풀이 알고리즘
	1. x가 몇 번째 대각선에 있는지 구한다.
		- x에서 n번째 원소를 뺏을 때 0이거나 음수라면, x는 n+1번째 index에 있는 것이다. 반복문은 0부터 시작하니 n+1 번째라 하겠다.
	2. index번호가 홀수면 대각선 아래에서 부터 올라가는 순서(분자가 작아지고 분모가 커짐)이고
		짝수면 대각선 위에서부터 내려오는 순서(분자가 커지고 분모가 작아짐)이다. 
	예를 들어 설명하자면, 4의 경우에는 4-6을 했을 때 -2, 즉 음수가 나오므로 3번째 줄에 있다.(1 3 6 ...)
	그리고 3번째라면 홀수이고 홀수는 올라가는 순서, 즉 분자가 작아지고 분모가 커지게 된다. 
	3번째 줄의 시작은 분자가 가장 큰 형태인 3/1부터 시작해서 2/2 1/3 이런 순서이다.
	그리고 *3번째 대각선의 경우 총 3개의 요소를 가지고있다.* <- 중요하다.
	앞에서 빼기를 했을 때 만약 0이 나오는 숫자가 있다면 해당 숫자가 해당 대각선의 시작 숫자이다. (예시: 6)
	그러면 -2라는 것은 0부터 시작해 3번째 요소라는 말과 같다!
	즉, x=4의 경우에는 대각선의 끝에 있다는 소리이고, 다시 말하지만 홀수의 경우에는 분자가 작아지고 분모가 커지는데 
	그렇다는 말은 홀수 => 분자 = 내림차순 , 분모 = 오름차순
	그런데 4는 젤 끝에 있는 숫자니깐 가장 가장 작은 분자 그리고 가장 큰 분모를 가진다
	따라서 3/1 이다.
*/

public class N1193_easyMath {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int x = Integer.parseInt(br.readLine());
			int n = 0;	// n 번째
			int sum = 0;
			int order = 0;

			while(true) {
				
				sum = sum + (n + 1);	// 모든 수의 합.
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
