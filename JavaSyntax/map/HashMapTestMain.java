package map;

import java.util.*;
////
public class HashMapTestMain {
    static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<String, HashMap<String, String>>();
    public static void main(String[] args) {
        addNumberToBook("Company","Kim","010-222-2222");
        addNumberToBook("Company","Kim","010-3122-2222");
        addNumberToBook("Company","Park","992-ab22-2zb38");
        addNumberToBook("Jeong","dkfjeilfefkjd");
        addNumberToBook("School","Lee","010-3991-9185");
        addNumberToBook("School","Oh","010-8592-9421");

        printList();

    }
    static void addNumberToBook(String listName, String name, String phoneNumber) {
        addGroup(listName);     // 만약 그룹 네임이 없으면 새로 만들어짐
        HashMap<String,String> group = phoneBook.get(listName); //  해당 그룹 이름(key)의 HashMap(Value)를 가지고 온다.
        // 가지고 온 인스턴스의 HashMap 에 계속 추가해 나가는 방식.
        group.put(phoneNumber,name);
    }

    static void addNumberToBook(String name, String phoneNumber) {
        addNumberToBook("Etc.",name,phoneNumber);
    }

    static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName)) {
            phoneBook.put(groupName,new HashMap<String,String>());
        }
    }

    static void printList() {
        Set<Map.Entry<String,HashMap<String,String>>> set = phoneBook.entrySet(); // iterator 를 사용하기 위해 set 반환
        // 이때 자료형은 Map.Entry 이다.
        Iterator<Map.Entry<String,HashMap<String,String>>> it = set.iterator();   // 순환을 위한 it
        // 바로 밑에 e 생략가능.

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();    // it.next()의 값은 String 과 HashMap<String,String> 으로 이루어진 Map.Entry임.

            Set subsSet = ((HashMap)e.getValue()).entrySet();
            Iterator subsIt = subsSet.iterator();

            System.out.println(" * " + e.getKey() + "[" + subsSet.size() + "]");

            while(subsIt.hasNext()){
                Map.Entry subsE = (Map.Entry) subsIt.next();
                String tel = (String)subsE.getKey();
                String name = (String)subsE.getValue();
                System.out.println(name + " " + tel);
            }
            System.out.println();
        }
    }
}

