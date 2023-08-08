package N11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int n,x;
        try {
            n = Integer.parseInt(br.readLine());
            for (int i=0;i<n;i++){
                x = Integer.parseInt(br.readLine());
                if(x == 0){
                    if(heap.isEmpty())
                        sb.append(0).append('\n');
                    else sb.append(heap.poll()).append('\n');
                }
                else
                    heap.add(x);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb.toString());
    }
}
