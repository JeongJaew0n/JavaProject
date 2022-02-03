package iterator;

import java.util.Iterator;

public class MyVectorTest {
    public static void main(String[] args) {
        MyVector mv = new MyVector();

        mv.add(1);
        mv.add(2);
        mv.add(3);
        mv.add(4);
        mv.add(5);

        System.out.println(mv.toString());

        MyVector it = (MyVector) mv.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
            it.remove();
            System.out.println(it.cursor);
            System.out.println(it.lastRet);
        }
    }
}
