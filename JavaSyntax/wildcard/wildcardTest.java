package wildcard;

import java.util.ArrayList;
import java.util.Collection;

public class wildcardTest {
    public static void main(String[] args) {
        Collection<Integer> testColllection = new ArrayList<>();
        testColllection.add(1233);
        printCollection(testColllection);
    }

    static void printCollection(Collection<? extends Number> c) {
        for (Number e : c) {
            System.out.print(e);
        }
    }

}
