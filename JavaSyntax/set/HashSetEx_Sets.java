package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx_Sets {
    public static void main(String[] args) {
        HashSet<Integer> hashSetA = new HashSet<>();
        HashSet<Integer> hashSetB = new HashSet<>();

        HashSet<Integer> hashSetIntersection = new HashSet<>();
        HashSet<Integer> hashSetDifference= new HashSet<>();
        HashSet<Integer> hashSetSum= new HashSet<>();

        for (int i = 0; i < 10; i++) {
            hashSetA.add(i+1);
            hashSetB.add(i+5);
        }
        Iterator it = hashSetA.iterator();
        while(it.hasNext()){
            int n = (int)it.next();
            if(hashSetB.contains(n)){
                hashSetIntersection.add(n);
            }
            if(!hashSetB.contains(n)){
                hashSetDifference.add(n);
            }
            hashSetSum.add(n);
        }

        it = hashSetB.iterator();
        while(it.hasNext()){
            int n = (int)it.next();
            hashSetSum.add(n);
        }

        System.out.println(hashSetIntersection);
        System.out.println(hashSetDifference);
        System.out.println(hashSetSum);

    }
}
