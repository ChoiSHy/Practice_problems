package Bakjun.N11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 연결 요소 개수 */
public class Main {
    static BufferedReader br;
    static boolean[] visited;
    static List<Integer>[] adjList;
    static int n,m;

    public static void main(String[] args){
        br= new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        try {
            input();
            for(int i=1;i<n+1;i++)
                if(!visited[i]){
                    dfs(i);
                    cnt++;
                }
            System.out.println(cnt);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void input() throws IOException {
        String[] inputs= br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        adjList = new List[n+1];
        visited = new boolean[n+1];

        for(int i =0; i<n+1;i++)
            adjList[i] = new ArrayList<>();

        for(int i=0;i<m;i++){
            inputs= br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            adjList[a].add(b);
            adjList[b].add(a);
        }
    }
    public static void dfs(int cur){
        visited[cur] = true;
        for(int next : adjList[cur]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
