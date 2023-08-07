package N2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer>[] adjList;
        boolean[] visited;
        int vtx, edg;
        try {
            vtx = Integer.parseInt(br.readLine());
            edg = Integer.parseInt(br.readLine());

            adjList = new List[vtx];

            for (int i = 0; i < vtx; i++)
                adjList[i] = new ArrayList();
            String[] inputs;
            for (int i = 0; i < edg; i++) {
                inputs = br.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);

                adjList[a - 1].add(b);
                adjList[b - 1].add(a);
            }
        } catch (IOException E) {
            throw new RuntimeException(E);
        }
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[vtx];

        int cnt = 0;
        visited[0] = true;
        for (int i : adjList[0])
            queue.add(i);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (!visited[v - 1]) {
                visited[v - 1] = true;
                cnt++;
                for (int i : adjList[v - 1]) {
                    if (!visited[i - 1])
                        queue.add(i);
                }
            }
        }
        System.out.println(cnt);
    }
}
