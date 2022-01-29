package easyLevel;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10828_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        try {
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                if(order.equals("push"))
                    stack.push(Integer.parseInt(st.nextToken()));

                else if(order.equals("pop")){
                    if(stack.empty())
                        sb.append(-1);
                    else
                        sb.append(stack.pop());
                    sb.append("\n");

                } else if (order.equals("size")) {
                    sb.append(stack.size() + "\n");

                } else if (order.equals("empty")) {
                    if(stack.empty())
                        sb.append(1);
                    else
                        sb.append(0);
                    sb.append("\n");

                } else if (order.equals("top")) {
                    if(stack.empty())
                        sb.append(-1);
                    else
                        sb.append(stack.peek());
                    sb.append("\n");
                }
            }
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
