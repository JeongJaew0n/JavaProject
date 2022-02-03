package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] obj = {1,9999,'5',"5",5,"2","2",'3',"3",4,'4',8,"8"};

        ArrayList arrayList = new ArrayList(Arrays.asList(obj));

        Set hashSet = new HashSet();

        hashSet.addAll(arrayList);
        System.out.println(hashSet);
    }
}
