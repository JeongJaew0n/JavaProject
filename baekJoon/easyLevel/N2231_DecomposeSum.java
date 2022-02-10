package easyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2231_DecomposeSum {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int inputNumber = Integer.parseInt(br.readLine());
            int digit = String.valueOf(inputNumber).length();
            int maxSum = digit * 9;

            int calNum;
            int constructor = 0;
            for (int i = inputNumber - maxSum; i < inputNumber; i++) {
                int temp = i;
                calNum = temp;
                while(temp != 0) {
                    calNum += temp%10;
                    temp = temp/10;
                }
                if(calNum == inputNumber) {
                    constructor = i;
                    break;
                }
            }
            System.out.println(constructor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
