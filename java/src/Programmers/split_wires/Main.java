package Programmers.split_wires;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        s.solution(4, new int[][]{{1,2},{2,3},{3,4}});
        s.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}});

    }
}

class Patrol {
    boolean[] visit;
    int n;
    List<Integer>[] wire;

    public Patrol(int n, int[][] wires) {
        this.n = n;
        visit = new boolean[n + 1];
        wire = new List[n + 1];
        for (int i = 0; i < n + 1; i++)
            wire[i] = new ArrayList<>();
        for (int[] edge : wires) {
            wire[edge[0]].add(edge[1]);
            wire[edge[1]].add(edge[0]);
        }
    }

    public void reset() {
        for (int i = 1; i < n + 1; i++)
            visit[i] = false;
    }

    public int patrol(int v, int negh) {
        int ret = 1;
        visit[v] = true;
        for (int vtx : wire[v]) {
            if (!visit[vtx] && vtx != negh) {
                ret += patrol(vtx, negh);
            }
        }
        return ret;
    }
}
class Solution {
    Patrol p;

    public int solution(int n, int[][] wires) {
        int answer = 100;
        p = new Patrol(n, wires);
        for(int[] w : wires){
            int res = start(w);
            if(answer > res)
                answer = res;
        }
        return answer;
    }
    public int start(int[] w){
        int A, B;
        int ret=0;
        p.reset();
        A = p.patrol(w[0], w[1]);
        B = p.patrol(w[1], w[0]);
        ret = A-B > 0 ? A-B : B-A;
        return ret;
    }
}
