package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2798_BlackJack {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cards;

        try {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            cards = new int[n];

            int sum;
            int rightNumber = 0;

            input  = br.readLine();
            st = new StringTokenizer(input);

            for (int i = 0; i < n; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            /* n-2 and n-1 is so good code. I read it in rank1's code*/
            for(int i=0; i<n-2; i++){
                for(int j=i+1; j<n-1; j++){
                    for(int k=j+1; k<n; k++){
                        sum = cards[i] + cards[j] + cards[k];
                        if(sum <= m && sum > rightNumber) {
                            rightNumber = sum;
                        }
                    }
                }
            }
            System.out.println(rightNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
