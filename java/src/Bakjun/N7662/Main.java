package Bakjun.N7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Main {
    static HashMap<Integer, Integer> count;
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        input();
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++)
            test(Integer.parseInt(br.readLine()));
    }

    public static void test(int k) throws IOException {
        count = new HashMap<>();
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        String[] inputs;
        for (int i = 0; i < k; i++) {
            inputs = br.readLine().split(" ");
            if (inputs[0].compareTo("I") == 0)
                insert(Integer.parseInt(inputs[1]));

            else if (inputs[0].compareTo("D") == 0) {
                int v = Integer.parseInt(inputs[1]);
                if (v > 0)
                    deleteMax();
                else
                    deleteMin();
            }
        }
        while (true) {
            if (maxHeap.peek() != null) {
                int top = maxHeap.peek();
                if (count.get(top) == 0) {
                    maxHeap.poll();
                } else break;
            } else
                break;

        }
        while (true) {
            if (minHeap.peek() != null) {
                int top = minHeap.peek();
                if (count.get(top) == 0)
                    minHeap.poll();
                else break;
            } else
                break;

        }
        int c = 0;
        for (int v : count.values())
            c += v;

        if(c == 0)
            sb.append("EMPTY\n");
        else
            sb.append(maxHeap.peek() + " " + minHeap.peek() + "\n");
    }

    public static void insert(int i) {
        if (count.containsKey(i))
            count.put(i, count.get(i) + 1);
        else
            count.put(i, 1);
        minHeap.add(i);
        maxHeap.add(i);
    }

    public static void deleteMax() {
        if (maxHeap.peek() == null)
            return;
        int n = maxHeap.poll();
        int cnt = count.get(n);

        if (cnt != 0) {
            count.put(n, cnt - 1);
        } else
            deleteMax();
    }

    public static void deleteMin() {
        if (minHeap.peek() == null)
            return;
        int n = minHeap.poll();
        int cnt = count.get(n);

        if (cnt != 0) {
            count.put(n, cnt - 1);
        } else
            deleteMin();
    }
}