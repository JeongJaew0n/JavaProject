package easyLevel;

import java.io.*;

public class N5598_CaesarCipher {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        try {
            char[] decodingStr = br.readLine().toCharArray();
            for (int i = 0; i < decodingStr.length; i++) {
                decodingStr[i] = (char)(decodingStr[i] - 3);
                if(decodingStr[i] < 'A'){
                    decodingStr[i] =(char)(decodingStr[i] + 26);
//                    decodingStr[i] -= 26;
                }
            }
            bw.write(decodingStr);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
