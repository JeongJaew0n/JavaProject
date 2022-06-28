package iterator;
//
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class MyVector extends ArrayList implements Iterator {
    int cursor = 0;     // 현재 위치
    int lastRet = -1;  // 이전 위치

    public MyVector(int capacity) {
        super(capacity);
    }

    public MyVector() {
        this(10);
    }

    public String toString() {
        String tmp = "";
        Iterator iterator = iterator();

        for(int i=0; iterator.hasNext(); i++){
            if(i!=0) tmp+=", ";
            tmp += iterator.next();
        }
        return "[" + tmp + "]";
    }

    public Iterator iterator() {
        cursor = 0;
        lastRet = -1;
        return this;    // MyVector 를 리턴함
        // this -> 현재 객체(인스턴스)의 참조값을 전달
        // 자기 자신을 반환하는 것이다.

        /* 예를 들어 ArrayList 의 경우에는
        *  Iterator 인터페이스를 상속받아 구현한다.
        *  그리고 안에 자기 자신을 반환하는 iterator() 함수가 있다.
        *  그러면 iterator() 는 ArrayList 를 순회할 수 있도록
        *  현재 위치나 마지막 위치와 같은 변수를 조정하거나
        *  뭐 기타등등 작업들을 한 뒤
        *  자기 자신의 객체(인스턴스)를 돌려준다.
        *  그러면 해당 객체를 넘겨받은 Iterator 변수(인스턴스)가
        *  해당 객체(참조값 == 주소 == 인스턴스 정보)를 넘겨받아
        *  순회하거나 삭제하거나 한다.
        * */
    }

    @Override
    public boolean hasNext() {
        return cursor!=size();
    }

    @Override
    public Object next() {
        Object next = get(cursor);
        lastRet = cursor++;
        return next;
    }

    @Override
    public void remove() {  // 반드시 next()가 호출된 다음 호출되어야 작동함.
        if (lastRet == -1) {   // 아무것도 없으면
            throw new IllegalStateException();
        }
        remove(lastRet);
        cursor--;
        lastRet = -1;
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }
}
