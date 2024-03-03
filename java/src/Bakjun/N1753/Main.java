package Bakjun.N1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
    int to;
    int w;
    Edge(int to, int w){
        this.to=to;
        this.w=w;
    }
    @Override
    public int compareTo(Edge o) {
        return w-o.w;
    }
}
public class Main {
    static int v, e;
    static int start;
    static List<Edge>[] vlist;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;
        inputs = br.readLine().split(" ");
        v = Integer.parseInt(inputs[0]);
        e = Integer.parseInt(inputs[1]);
        start = Integer.parseInt(br.readLine());

        vlist = new List[v+1];
        for(int i=1;i<v+1;i++)
            vlist[i]=new ArrayList<>();

        for(int i=0;i<e;i++){
            inputs = br.readLine().split(" ");
            int f = Integer.parseInt(inputs[0]);
            int t = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);

            vlist[f].add(new Edge(t, w));
        }
        dijkstra();
        for(int i=1;i<v+1;i++){
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF":dist[i]);
        }
    }
    public static void dijkstra(){
        dist=new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0));

        while(!q.isEmpty()) {
            Edge cur = q.poll();
            if (dist[cur.to] < cur.w) continue;

            for(Edge next : vlist[cur.to]){
                int nextDis = cur.w + next.w;
                if(nextDis < dist[next.to]){
                    dist[next.to] = nextDis;
                    q.add(new Edge(next.to, nextDis));
                }
            }
        }
    }
}
