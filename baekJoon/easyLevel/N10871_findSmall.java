package easyLevel;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
//
//입력: 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
//둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.

//출력: X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.

public class N10871_findSmall {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//수열의 갯수 N
			int X = Integer.parseInt(st.nextToken());	//작은 값을 찾을 기준이 되는 값 X
			
			int[] arr = new int[N];		//N갯수의 수열을 저장할 배열
			ArrayList<Integer> smaller = new ArrayList<>();	//작은 값을 찾았을 때 저장하기 위한 ArrayList
			//쓴 이유: 보다 작은 값이 몇 개나 나올지 모르기 때문에 최소 N과 같은 크기의 배열을 선언해줘야 한다. 이러면 불필요한 메모리를 할당받을 수 있다.
			
			StringTokenizer input_arr = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(input_arr.nextToken());
				if(arr[i] < X) {
					smaller.add(arr[i]);
				}
			}
			for(int i=0; i<smaller.size(); i++) {
				System.out.print(smaller.get(i));
				if(i!=smaller.size()-1) System.out.print(" ");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
