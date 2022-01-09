package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1546_DivideFloat {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			int subjectNumber = Integer.parseInt(br.readLine());
			
			int[] subjectScores = new int[subjectNumber];
			float[] fakeScores = new float[subjectNumber];
			float fakeScoreSum = 0;
			int maxScore = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<subjectScores.length; i++) {
				subjectScores[i] = Integer.parseInt(st.nextToken());
				if(subjectScores[i] > maxScore) {
					maxScore = subjectScores[i];
				}
			}
			
			for(int i=0; i<subjectScores.length; i++) {
				if( subjectScores[i] * maxScore !=0 ) {
					fakeScores[i] = (float)subjectScores[i]/maxScore * 100;
				}
				fakeScoreSum += fakeScores[i];
			}
			if(subjectNumber != 0) {
				System.out.println(fakeScoreSum/subjectNumber);
			}
			else 
				System.out.println(0);
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
