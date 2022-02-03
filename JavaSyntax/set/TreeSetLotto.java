package set;

import java.util.TreeSet;


/* 이미 정렬이 되어 있어서 정렬할 필요가 없음 */
public class TreeSetLotto {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet();

        while(treeSet.size()<7) {
            treeSet.add((int)(Math.random() * 45 + 1));
        }

        System.out.println(treeSet);
    }
}
