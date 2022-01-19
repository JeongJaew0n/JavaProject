package queue;

import java.util.Queue;

public class MyQueue<E> implements QueueInterface<E> {
    Object[] datas;

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
