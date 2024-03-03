package Bakjun.N1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean distance(Node node) {
        int d = 0;
        if (this.x == node.x)
            d = this.y - node.y;
        else if (this.y == node.y)
            d = this.x - node.x;
        else
            return false;
        if (d == -1 || d == 1)
            return true;
        return false;
    }
}

class Graph {
    int cnt;
    Node[] nodes;
    List<Integer>[] adList;

    public Graph(int k) {
        this.cnt = 0;
        this.nodes = new Node[k];
        this.adList = new List[k];
        for (int i = 0; i < k; i++)
            adList[i] = new ArrayList();
    }

    public void push(Node newOne) {
        nodes[cnt] = newOne;
        for (int i = 0; i < cnt; i++) {
            if (i == cnt) continue;
            if (nodes[cnt].distance(nodes[i])) {
                adList[cnt].add(i);
                adList[i].add(cnt);
            }
        }
        cnt++;
    }

    public int getAnswer() {
        int res = 0;
        boolean[] check = new boolean[cnt];

        Stack<Integer> stack = new Stack<>();

        for (int i = cnt-1; i >= 0; i--) {
            if (check[i])
                continue;
            res++;
            stack.push(i);
            while (!stack.isEmpty()) {
                int top = stack.pop();
                if(!check[top]){
                    check[top]=true;
                    for (int j: adList[top]){
                        if(!check[j])
                            stack.push(j);
                    }
                }
            }
        }
        return res;

    }

}

public class Main {
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0;t<T;t++)
            testCase();
        System.out.println(sb.toString());
    }

    public static void testCase() throws IOException {
        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        int K = Integer.parseInt(inputs[2]);
        Graph g = new Graph(K);

        for (int i = 0; i < K; i++) {
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            g.push(new Node(x, y));
        }
        sb.append(g.getAnswer()+"\n");
    }
}
