package comparable;

import java.util.Arrays;
import java.util.Comparator;

public class Coms2 {
    public static void main(String[] args) {
        String[] strArr = {"cat", "elephant", "dog", "monkey", "lion"};
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Comparable<?>&& o2 instanceof Comparable<?>){
                        Comparable c1 = (Comparable) o1;
                        return c1.compareTo(o2)*-1;
                }
                return -1;  // 정렬 불가
            }
        };

        System.out.println(Arrays.toString(strArr));

        Arrays.sort((strArr));
        System.out.println(Arrays.toString(strArr));
        Arrays.sort(strArr,comparator);
        System.out.println(Arrays.toString(strArr));

    }
}
