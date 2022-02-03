package set;

import java.util.*;

public class TreeSetEx_Methods {
    public static void main(String[] args) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o1 = o1.toLowerCase();
                o2 = o2.toLowerCase();
                // 여기서 이제 부모껄 넣어주면 될거같은데
                return o1.compareTo(o2);
                // o2.compareTo(o1)으로 하면 역순이 됨.
                // 그러면 subSet에서 찾는 것도 역순으로 해줘야함
                // fromKey 를 "z" , toKey 를 "a" 로
            }
        };

        TreeSet<String> treeSet = new TreeSet<>(myComp);
        treeSet.add("Car");
        treeSet.add("Hello");
        treeSet.add("apple");
        treeSet.add("volta");
        treeSet.add("legend");
        treeSet.add("whole");
        treeSet.add("university");
        treeSet.add("pizza");
        treeSet.add("gentleman");

        System.out.println(treeSet);
        System.out.println(treeSet.subSet("a","h"));
        System.out.println(treeSet.subSet("a","h" + "zzzzz"));
        System.out.println(treeSet.headSet("w"));
        System.out.println(treeSet.tailSet("w"));
    }

}
