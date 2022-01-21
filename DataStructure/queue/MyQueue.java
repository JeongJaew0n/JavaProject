package queue;

import java.util.Arrays;
import java.util.Queue;

public class MyQueue<E> implements QueueInterface<E> {
    
    Object[] datas; // 데이터가 저장될 배열
    private int capacity = 10;

    private final int front = 0;  // Queue 앞쪽
    private int rear = 1;   // Queue 뒤쪽, 데이터의 갯수

    MyQueue() {
        datas = new Object[capacity];
    }

    MyQueue(int capacity) {
        datas = new Object[capacity];
    }

    @Override
    public boolean offer(E e) { // Enqueue
        datas[rear-1] = e;
        rear++;
        return true;
    }

    @Override
    public E poll() {
        if(rear == 0 )
            return null;

        Object removedData = datas[front];

        for(int i=0; i<rear-1; i++) {
            datas[i] = datas[i+1];
        }
        datas[rear-1] = null;
        rear--;
        return (E)removedData;
    }

    @Override
    public E peek() {
        if(rear == 0 )
            return null;
        return (E) datas[front];
    }
}
