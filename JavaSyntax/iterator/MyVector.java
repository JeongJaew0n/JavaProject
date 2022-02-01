package iterator;

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
        return this;    // ArrayList 의 iterator 반환 return iterator()와 같음
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
