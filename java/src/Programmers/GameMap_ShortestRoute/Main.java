package Programmers.GameMap_ShortestRoute;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] maps1 = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int[][] maps2 = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        Solution s = new Solution();
        System.out.println(s.solution(maps1));
        System.out.println();
        System.out.println(s.solution(maps2));
    }
}

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    int[][] maps;
    int w, h;

    public int solution(int[][] maps) {
        int answer = -1;
        this.maps = maps;
        h = maps.length;
        w = maps[0].length;
        if(solve())
            answer = maps[h - 1][w - 1];
        return answer;
    }

    boolean solve() {
        int x = 0;
        int y = 0;
        int val;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        queue.add(new int[]{x, y, 1});
        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            x= pos[0];
            y= pos[1];
            val = pos[2];
            if (visited[x][y])
                continue;
            visited[x][y] = true;
            if(maps[x][y] == 1 || maps[x][y] > val)
                maps[x][y] = val;

            for (int i = 0; i < 4; i++) {
                int px = x + dx[i], py = y + dy[i];
                if (outOfIndex(px, py)) {
                    queue.add(new int[]{px, py, val + 1});
                }
            }
            val++;
        }
        if (visited[h - 1][w - 1])
            return true;
        return false;
    }


    boolean outOfIndex(int x, int y) {
        if (0 <= x && x < h)
            if (0 <= y && y < w)
                if (maps[x][y] != 0)
                    return true;
        return false;
    }
}