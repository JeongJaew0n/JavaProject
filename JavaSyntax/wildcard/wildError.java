package wildcard;

import java.util.ArrayList;
import java.util.Collection;

class testComp implements  Comparable<testComp> {
/* 자 여기서 testComp는 Comparable을 구현해서 이제 정렬이 가능해졌음.
그런데 정렬 할려면 크고작음이 있어야하기 때문에 반드시 compareTo 를 오버라이드해야함.
작으면 음수 같으면 0 크면 양수
* */
    @Override
    public int compareTo(testComp o) {

        return 0;
    }
}

class Person {
    int index;
}

class Student extends  Person implements Comparable<Person> {

    int myindex = 10;
    @Override
    public int compareTo(Person o) {

        return o.index - myindex;
    }
}

/* 이제 아직 안정했지만, 우리가 E라는 클래스(타입)를 하나 쓸거야.
*  그런데 여기서 E가 비교가능한 Comparable 을 구현하고 있으면 좋겠어. 왜냐면 아마도 비교를 할 거니까!!!!! 그래서 정렬 할끄어니까!!!!!!!!!!!!!!!!!!!!!
*  그래서 Comparable을 구현하는데, Comparable 도 링크드 리스트 마냥 여러 타입이 들어갈 수 있잖아?
*  그런데!!!!!!!!! 비교할려면 말이지!!!!!
*  부모는 여러 자식꺼를 막 잡아다 쓸 수 있어.
*  그런데 형제끼리는 서로 못 가져다 써.
*  예를 들어 자식 하나에 int money라는 변수가 있다고 치자
*  그런데 같은 부모에게서 구현하는 다른 자식은 money변수가 없어!!!
*  그러면 Comparable<E> 이따구로 했을 때
*
* */

public class wildError<E extends Comparable<? super E>>  {
    public static void main(String[] args) {
    }

    E data;

}
