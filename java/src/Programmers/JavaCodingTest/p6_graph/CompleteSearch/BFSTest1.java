package Programmers.JavaCodingTest.p6_graph.CompleteSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int [][] field = new int[n][m];
        for(int i = 0;i<n;i++){
            String input = scanner.nextLine();
            for(int j = 0;j<m;j++){
                field[i][j] = input.charAt(j)-'0';
            }
        }
        Solution3 s = new Solution3();
        s.solution(n,m,field);
    }
}
class Solution3 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    int[][] maps;
    int w, h;

    public int solution(int n, int m,int[][] maps) {
        int answer = -1;
        this.maps = maps;
        h = n;
        w = m;
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
