package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UnixHistory {
    static Queue<String> queue = new LinkedList();
    static final int MAX_SIZE = 5;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("help를 입력해주세요");
                String order = br.readLine();
                if (order.equals("help")) {
                    save(order);
                } else if (order.equals("history")) {
                    save(order);
                    queue.forEach(s -> System.out.println(s));
                } else if(order.equals("q") || order.equals("Q")) {
                    break;
                }
                else {
                    save(order);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static void save(String input) {
        if(!input.equals(""))
             queue.offer(input);
        if (queue.size() > MAX_SIZE) {
            queue.remove();
        }
    }

}
