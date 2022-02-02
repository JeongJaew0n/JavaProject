package set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class HashSetLotto {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        while(hashSet.size() < 7) {
            int num = (int)(Math.random() * 45) + 1;
            hashSet.add(num);
        }

        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addAll(hashSet);

        Collections.sort(linkedList);
        System.out.println(linkedList);
    }
}
