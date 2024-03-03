package Programmers.KaKao_2022_blind_recruitment.Sheep_and_Wolf;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();/*
        s.solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}
        );*//*
        s.solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}, {3, 12}, {12, 13}}
        );*/

        s.solution(
                new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}
        );
    }
}

class Solution {
    int[] info;
    List<Integer>[] graph;
    boolean[][][] visit;
    int answer;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.graph = new List[info.length];
        for (int i = 0; i < info.length; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visit = new boolean[info.length][info.length+1][info.length+1];
        answer = 0;

        dfs(0,0,0);

        return answer;
    }

    public void dfs(int cur, int sheep, int wolf) {
        if(info[cur] == 0) sheep++;
        else if(info[cur]==1) wolf++;

        if(wolf>= sheep) return;

        answer = answer < sheep ? sheep : answer;

        for(int i : graph[cur]){
            int next = i;
            int temp = info[cur];

            if(!visit[cur][sheep][wolf]){
                info[cur] = -1;
                visit[cur][sheep][wolf] = true;
                dfs(next, sheep,wolf);
                info[cur] = temp;
                visit[cur][sheep][wolf] = false;
            }
        }
    }
}
