package N5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* AC */
class Test {
    boolean front;
    char[] ops;
    Deque<Integer> deque;

    public Test(String ops, int[] arr) {
        this.front = true;
        this.ops = ops.toCharArray();
        this.deque = new ArrayDeque<>();
        for (int i : arr)
            deque.add(i);
    }

    public String run() {
        for (char op : ops) {
            if (op == 'R')
                front = !front;
            else if (op == 'D') {
                if (deque.isEmpty())
                    return "error";
                if (front) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            if (front) {
                sb.append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());
            }
            if (!deque.isEmpty())
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

}

public class Main {
    static BufferedReader br;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        try {
            int t = Integer.parseInt(br.readLine());
            for( int i =0 ; i<t;i++){
                Test test = dataInput();
                sb.append(test.run()).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb.toString());
    }

    public static Test dataInput() {
        try {
            String ops = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split("\\W");

            int[] data = new int[n];

            for(int i=1;i<=n;i++)
                data[i-1] = Integer.parseInt(inputs[i]);

            return new Test(ops,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
