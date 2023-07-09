package N1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
DFS $ BFS
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력
방문할 점이 여러 개인 경우엔 정점 번호가 작은 것 먼저
정점은 1 ~ N까지 존재

정점의 개수 N
간선의 개수 M
탐색 시작할 정점 번호 V

입력으로 주어진 간선은 양방향이다.
*/
public class Main {
    static int n, m, v;
    static List<Integer>[] adjList;
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        setting();
        input_data();
        DFS();
        BFS();
        System.out.println(sb);
    }

    private static void setting() throws Exception {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        v = Integer.parseInt(inputs[2]);

        adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private static void input_data() throws Exception {
        String[] inputs = null;
        int a, b;
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);

            adjList[a - 1].add(b);
            adjList[b - 1].add(a);
        }
    }
    public static void DFS() {
        boolean[] check = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (!check[top - 1]) {
                check[top - 1] = true;
                sb.append(top + " ");
                Collections.sort(adjList[top-1], Collections.reverseOrder());
                for (int i : adjList[top - 1]) {
                    if (!check[i - 1]) {
                        stack.push(i);
                    }
                }
            }
        }
        sb.append("\n");
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n];

        queue.add(v);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            if (!check[t - 1]) {
                sb.append(t+" ");
                check[t-1] = true;
                Collections.sort(adjList[t-1]);
                for(int i : adjList[t-1]){
                    if(!check[i-1])
                        queue.add(i);
                }
            }
        }
        sb.append("\n");
    }
}
