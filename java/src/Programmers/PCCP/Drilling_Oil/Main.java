package Programmers.PCCP.Drilling_Oil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] land1 = {
                new int[]{0, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 1, 1, 0, 0},
                new int[]{1, 1, 0, 0, 0, 1, 1, 0},
                new int[]{1, 1, 1, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 0, 0, 0, 1, 1}
        };
        int[][] land2 = {
                new int[]{1, 0, 1, 0, 1, 1},
                new int[]{1, 0, 1, 0, 0, 0},
                new int[]{1, 0, 1, 0, 0, 1},
                new int[]{1, 0, 0, 1, 0, 0},
                new int[]{1, 0, 0, 1, 0, 1},
                new int[]{1, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1, 1}
        };

        Solution s1 = new Solution();
        Solution s2 = new Solution();
        System.out.println("answer: "+s1.solution(land1));
        System.out.println("answer: "+s2.solution(land2));
    }
}

class Solution {
    int[][] land;
    int[] count;
    int n;
    int m;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;
        count = new int[m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (range(x, y)) {
                    prove(x, y);
                }
            }
        }

        int[] ans = Arrays.stream(count).sorted().toArray();
        int answer = ans[m - 1];
        return answer;
    }

    private void prove(int x, int y) {
        Set<Integer> route = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        int size = 0;
        int[] cur = new int[]{x, y};
        queue.add(cur);

        while (!queue.isEmpty()) {
            cur = queue.remove();
            if (range(cur[0], cur[1])) {
                size++;
                land[cur[0]][cur[1]] = 0;
                route.add(cur[1]);
                for (int i = 0; i < 4; i++) {
                    int X = cur[0] + dx[i];
                    int Y = cur[1] + dy[i];

                    if (range(X, Y)) {
                        queue.add(new int[]{X, Y});
                    }
                }
            }
        }
        for (int Y : route) {
            count[Y] += size;
        }
    }

    private boolean range(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m && land[x][y] == 1)
            return true;
        return false;
    }
}
