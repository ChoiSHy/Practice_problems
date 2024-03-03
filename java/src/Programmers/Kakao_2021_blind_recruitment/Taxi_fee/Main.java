package Programmers.Kakao_2021_blind_recruitment.Taxi_fee;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(
                6, 4, 6, 2,
                new int[][]{
                        {4, 1, 10},
                        {3, 5, 24},
                        {5, 6, 2},
                        {3, 1, 41},
                        {5, 1, 24},
                        {4, 6, 50},
                        {2, 4, 66},
                        {2, 3, 22},
                        {1, 6, 25}
                }
        );

        s.solution(
                7,3,4,1,
                new int[][]{
                        {5, 7, 9},
                        {4, 6, 4},
                        {3, 6, 1},
                        {3, 2, 3},
                        {2, 1, 6}
                }
        );

        s.solution(
                6,4,5,6,
                new int[][]{
                        {2,6,6},
                        {6,3,7},
                        {4,6,7},
                        {6,5,11},
                        {2,5,12},
                        {5,3,20},
                        {2,4,8},
                        {4,3,9}
                }
        );
        s.solution(3, 1, 3,3,
                new int[][]{
                        {1,2,5000},
                        {2,3,1},
                        {1,3,100000}
                });
    }
}

class Solution {
    int n;
    int INF;
    boolean[] visit;
    int[][] d;
    int[][] dist;

    public int solution(int n, int s, int a, int b,int[][] fares) {
        set(n, fares);
        for (int i = 1; i < n + 1; i++)
            dijkstra(i);
        int answer = find_shortest(s,a,b);

        return answer;
    }

    void set(int n, int[][] fares) {
        this.n = n;
        this.INF = n * 100000;

        visit = new boolean[n + 1];
        dist = new int[n + 1][n + 1];
        d = new int[n + 1][n + 1];
        for (int[] dis : dist)
            Arrays.fill(dis, INF);
        for (int[] edge : fares) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

    }

    int getSmallest(int start) {
        int min = INF;
        int idx = 0;
        for (int i = 1; i < n + 1; i++) {
            if (d[start][i] < min && !visit[i]) {
                min = d[start][i];
                idx = i;
            }
        }
        return idx;
    }

    void dijkstra(int start) {
        for (int i = 1; i < n + 1; i++) {
            if(i == start)
                d[i][i] = 0;
            else
                d[start][i] = dist[start][i];
            visit[i]=false;
        }
        visit[start] = true;

        for (int i = 1; i < n - 1; i++) {
            int cur = getSmallest(start);
            visit[cur] = true;
            for (int j = 1; j < n + 1; j++) {
                if (!visit[j]) {
                    if (d[start][cur] + dist[cur][j] < d[start][j])
                        d[start][j] = d[start][cur] + dist[cur][j];
                }
            }
        }
    }
    int find_shortest(int s, int a, int b){
        int ret = INF;
        int via=0;

        d[s][s] = 0;

        for(int i = 1; i < n+1; i++){
            int tmp = d[s][i] + d[i][a] + d[i][b];
            if(tmp < ret){
                ret = tmp;
                via = i;
            }
        }
        System.out.println(String.format("[%d]까지 합승, 요금: %d",via, ret));
        return ret;
    }
}