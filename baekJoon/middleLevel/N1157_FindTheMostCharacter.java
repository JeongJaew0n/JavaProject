package middleLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class N1157_FindTheMostCharacter {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        /* 알파벳이 26개니까 26크기의 배열을 만들어 준다.
         *  입력받은 문자열을 전부 대문자로 변환시킨다.
         *  */
        int[] alphabet = new int[26];
        int theMostChar = -1;
        int mostCharIndex = 0;

        try {
            String word = bufferedReader.readLine();
            if(word != null){

                word = word.toUpperCase();

                for (int i = 0; i < word.length(); i++) {

                    int index = word.charAt(i) - 'A';
                    alphabet[index]++;

                    if(alphabet[index] > theMostChar) {
                        theMostChar = alphabet[index];
                        mostCharIndex = index + 'A';
                    }
                    else if(alphabet[index] == theMostChar) {
                        mostCharIndex = '?';
                    }
                }
            }
            char thatChar = (char) mostCharIndex;
            System.out.println(thatChar + "\n" + theMostChar);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
