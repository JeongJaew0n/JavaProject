package stack;
////
import java.util.Arrays;

public class StackMain {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        for(int i=0; i<10; i++) {
            System.out.println(myStack.push(i*3));
        }
        System.out.println(myStack.search(12));

        for(int i=0; i<10; i++) {
            System.out.println(myStack.pop());
        }

        System.out.println(myStack.search(12));

    }
}
