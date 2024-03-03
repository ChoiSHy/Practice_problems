package Bakjun.N1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int idx, cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int n, m;
    static int src, dst;

    static List<Node>[] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = null;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            graph[from].add(new Node(to, cost));
        }

        inputs = br.readLine().split(" ");
        src = Integer.parseInt(inputs[0]);
        dst = Integer.parseInt(inputs[1]);

        dijksra();
    }

    public static void dijksra() {
        boolean visit[] = new boolean[n + 1];
        int[] dis = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dis, INF);
        dis[src] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(src, 0));

        while (!queue.isEmpty()) {
            int cur = queue.poll().idx;

            if (visit[cur]) continue;
            visit[cur] = true;

            for (Node next : graph[cur]) {
                if (dis[next.idx] > dis[cur] + next.cost) {
                    dis[next.idx] = dis[cur] + next.cost;

                    queue.offer(new Node(next.idx, dis[next.idx]));
                }
            }
        }
        System.out.println(dis[dst]);
    }
}
