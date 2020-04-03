import java.util.*;
public class P2 {	//실습3 문제2번

	public static void main(String[] args) {
		int[] numbers = new int[7];	//수 7개를 저장할 배열
		int save_n = 0;	//배열을 정렬하기 위해 값을 임시저장할 변수
		boolean count = false;	//2번째로 큰값이 존재하는가 판별 있으면 true, 없으면 false
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<7; i++) {
			numbers[i] = scan.nextInt();	//배열에 값을 받음
		}
		
		for(int i=0; i<6; i++) {	// 내림차순으로 정렬
			for(int j=0; j<6-i; j++) {
				if(numbers[j] < numbers[j+1]) {
					save_n = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = save_n;
				}
			}
		}
		
		for(int i=0; i<6; i++) {
			if(numbers[i] != numbers[i+1]) {	//같은 값을 제외하고 2번째 값을 출력 후 반복문 종료
				System.out.println(numbers[i+1]);
				count = false;	
				break;
			}
			count = true;
		}
		if(count) {	//2번째 값이 없음
			System.out.println("없음");
		}
	}

}
