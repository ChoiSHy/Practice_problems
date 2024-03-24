package Programmers.Terrain_Movement;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 지형 이동
 *
 * N x N 크기인 정사각 격자 형태의 지형이 있습니다.
 * 각 격자 칸은 1 x 1 크기이며, 숫자가 하나씩 적혀있습니다.
 * 격자 칸에 적힌 숫자는 그 칸의 높이를 나타냅니다.
 * 이 지형의 아무 칸에서나 출발해 모든 칸을 방문하는 탐험을 떠나려 합니다.
 * 칸을 이동할 때는 상, 하, 좌, 우로 한 칸씩 이동할 수 있는데,
 * 현재 칸과 이동하려는 칸의 높이 차가 height 이하여야 합니다.
 * 높이 차가 height 보다 많이 나는 경우에는 사다리를 설치해서 이동할 수 있습니다.
 * 이때, 사다리를 설치하는데 두 격자 칸의 높이차만큼 비용이 듭니다.
 * 따라서, 최대한 적은 비용이 들도록 사다리를 설치해서 모든 칸으로 이동 가능하도록 해야 합니다.
 * 설치할 수 있는 사다리 개수에 제한은 없으며, 설치한 사다리는 철거하지 않습니다.
 * 각 격자칸의 높이가 담긴 2차원 배열 land와 이동 가능한 최대 높이차 height가 매개변수로 주어질 때,
 * 모든 칸을 방문하기 위해 필요한 사다리 설치 비용의 최솟값을 return 하도록 solution 함수를 완성해주세요.
 *
 * */
class Solution {
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    int n;
    int[][] cost;
    PriorityQueue<int[]> notYet;
    Queue<int[]> queue;

    public int solution(int[][] land, int height) {
        int answer = 0;

        this.n = land.length;
        this.cost = new int[n][n];
        this.notYet = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        this.queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            Arrays.fill(cost[i], 10000);

        notYet.add(new int[]{0,0,0});
        while(!notYet.isEmpty()){
            int[] p = notYet.remove();
            if(cost[p[0]][p[1]] == 1) continue;
            answer+=p[2];
            //System.out.println("answer: "+p[2]+"++");
            bfs(land, p[0],p[1], height);
        }
        //System.out.println("answer: "+answer);
        return answer;
    }

    void bfs(int[][] land, int X, int Y, int height) {
        queue.add(new int[]{X, Y});

        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            int x = pos[0];
            int y = pos[1];
            cost[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isOutOfIndex(nx, ny)) {
                    if (cost[nx][ny] > 1) {
                        int d = Math.abs(land[x][y] - land[nx][ny]);
                        if (d < cost[nx][ny] && d <= height) {
                            queue.add(new int[]{nx, ny});
                            cost[nx][ny] = d;
                        } else
                            notYet.add(new int[]{nx, ny, d});
                    }
                }
            }
        }
    }


    boolean isOutOfIndex(int i, int j) {
        if (0 <= i && i < n && 0 <= j && j < n) return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{
                        {1, 4, 8, 10},
                        {5, 5, 5, 5},
                        {10, 10, 10, 10},
                        {10, 10, 10, 20}},
                3);
        System.out.println();
        s.solution(new int[][]{
                        {10, 11, 10, 11},
                        {2, 21, 20, 10},
                        {1, 20, 21, 11},
                        {2, 1, 2, 1}},
                1);
    }
}
