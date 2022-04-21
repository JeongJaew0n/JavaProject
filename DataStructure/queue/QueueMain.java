package queue;
//
public class QueueMain {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>(5);

        System.out.println(myQueue.offer("First Data"));
        System.out.println(myQueue.offer("Second Data"));
        System.out.println(myQueue.offer("Third Data"));

        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());

    }
}
