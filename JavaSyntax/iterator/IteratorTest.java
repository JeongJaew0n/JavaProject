package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        Iterator it = list.iterator();    이렇게 쓰면 concurrentmodificationException 발생

        list.add("Hello");
        list.add("Yal");
        list.add("yop");

        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
            String value = iterator.next();
//            value = iterator.next();      // next 한 번 더하면 오류 발생
            System.out.println(value);
        }
        System.out.println("-----------------------");
        for(ListIterator<String> listIterator = list.listIterator(); listIterator.hasNext();){
            String value = listIterator.next();
            System.out.println(value);
            if(listIterator.hasPrevious()){
                System.out.println("remove: " + (value = listIterator.previous()));
                listIterator.remove();
            }
            System.out.println(listIterator.hasNext() + " and " + list.isEmpty());
        }

    }
}
