package comparable;

import java.util.Arrays;
import java.util.Comparator;

public class sortTest {
    public static void main(String[] args) {
        MyInteger[] myInteger = new MyInteger[10];

        Comparator comt = new Comparator<MyInteger>() {
            @Override
            public int compare(MyInteger o1, MyInteger o2) {
                /* 순서 바꾸면 내림차순이 될라나? */
                if (o2.value - o1.value > 0) {
                    return 1;
                } else if (o2.value == o1.value) {
                    if(o2.number > o1.number)
                        return 1;
                    else if(o2.number == o1.number) {
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
                else
                    return -1;
            }
        };


        for (int i = 0; i < myInteger.length; i++) {
            myInteger[i] = new MyInteger((int)(Math.random() * 8));
        }

        Arrays.sort(myInteger,comt);

        for (MyInteger mI : myInteger) {
            System.out.println(mI.value + " 그리고" + mI.number);
        }
    }
}

class MyInteger implements Comparable<MyInteger>{

    int value;
    int number;

    MyInteger(int value) {
        this.value = value;
        this.number = (int)(Math.random()*10);
    }

    @Override
    public int compareTo(MyInteger o) {
        if (this.value - o.value > 0) {
            return 1;
        } else if (this.value == o.value) {
            return 0;
        }
        else
            return -1;
    }
}