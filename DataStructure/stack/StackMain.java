package stack;

import java.util.Arrays;

public class StackMain {
    public static void main(String[] args) {
        int[] k = new int[11];
        int[] j = new int[9];

        for(int i=0; i<k.length; i++) {
            k[i] = i;
        }

        for(int i=0; i<9; i++) {
            j[i] = i;
        }

        k = Arrays.copyOf(j,j.length+1);

        System.out.println(k.length);
    }
}
