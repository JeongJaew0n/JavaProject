package stack;

import java.util.Arrays;

public class MyStack implements  StackInterface<Integer>{

    int size = 10;
    int currentE = 0;
    int[] datas = new int[size];

    @Override
    public Integer push(Integer item) {
        if(currentE == size) {
            size++;
            int[] temp = datas.clone();
            datas = new int[size];
            datas = Arrays.copyOf(temp,size);
            datas[size] = item;

            currentE++;
            return item;
        }
        datas[currentE] = item;
        currentE = item;
        return null;
    }

    @Override
    public Integer pop() {
        if(currentE == 0) {
            System.out.println("스택에 아무것도 없습니다.");
        }
        datas[currentE] = 0;
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public int search(Object value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean empty() {
        return false;
    }
}
