package stack;

import java.util.Arrays;

public class MyStack<E> implements  StackInterface<E>{

    int capacity;
    int size = 0;    // 제일 위에 쌓여있는 데이터의 인덱스
    Object[] datas;  // 자료가 저장될 배열

    MyStack() { // 생성자
        this.capacity = 10;
        datas = new Object[capacity];
    }

    MyStack(int capacity) {
        this.capacity = capacity;
        datas = new Object[capacity];
    }

    private void reSize() {
        if(size == capacity) {          // 만약 꽉 찼다면
        capacity++;                     // 가용량을 한칸 늘리고
        Object[] temp = datas.clone();  // 복사를 위해 임시 배열을 만들어 원본 배열을 저장해두고
        datas = new Object[capacity];   // 커진 용량 만큼의 크기로 배열을 새로 만들어서
        datas = Arrays.copyOf(temp,capacity);   // 가용량만큼 복사한다. (마지막 자리는 비워져있게됨)
        return;
        }

        if(size < capacity/2) {    // 현재 가용량의 절반 미만으로 쓰고 있을 경우
            capacity = capacity/2;  // 가용량을 절반으로 줄이고
            Object[] temp = datas.clone();
            datas = new Object[capacity];   // 변화된 용량 만큼의 크기로 배열을 새로 만들어서
            datas = Arrays.copyOf(temp,capacity);   // 가용량 만큼 복사한다.
            return;
        }
    }


    @Override
    public E push(E item) {
        if(size == capacity) {
            reSize();
        }
        datas[size] = item;
        size++;
        return item;
    }

    @Override
    public E pop() {
        if(size == 0) {
            System.out.println("스택에 아무것도 없습니다.");
        }
        Object removedData = datas[size-1];
        datas[size-1] = null;
        size--;
        reSize();

        return (E) removedData;
    }

    @Override
    public E peek() {
        if(size == 0) {
            System.out.println("스택에 아무것도 아무것도 없습니다.");
            return null;
        }
        return (E) datas[size];
    }

    @Override
    public int search(Object value) {
        if(size == 0) {
            System.out.println("스택에 아무것도 아무것도 없습니다.");
            return -1;
        }
        for(int i=0; i<size-1; i++) {
            if(datas[i].equals(value)) {
                return i;
            }
        }

        System.out.println("일치하는 값이 없습니다.");
        return -1;
    }

    @Override
    public int size() {
        return size;      // 사이즈는 인덱스 이므로 크기를 나타내기 위해 +1
    }

    @Override
    public void clear() {
        if(size == 0) {
            System.out.println("스택에 아무것도 아무것도 없습니다.");
            return;
        }
        for(int i=0; i<size-1; i++) {
            datas[i] = null;
        }
        size = 0;
        reSize();
    }

    @Override
    public boolean empty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
}
