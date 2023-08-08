package N10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int[][] field;
    static int n;
    static boolean[][] check;
    static int[][] pos = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input();
        int res1 = test(true);
        int res2 = test(false);
        System.out.println(res1 + " " + res2);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        field = new int[n][n];
        for (int x = 0; x < n; x++) {
            char[] line = br.readLine().toCharArray();
            for (int y = 0; y < n; y++) {
                switch (line[y]) {
                    case 'B':
                        field[x][y] = 0;
                        break;
                    case 'R':
                        field[x][y] = 1;
                        break;
                    case 'G':
                        field[x][y] = 2;
                        break;
                }
            }
        }
    }


    static boolean isIn(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static int test(boolean b) {
        int cnt = 0;
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    dfs(i, j, b);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y, boolean rg) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int px = x + pos[i][0];
            int py = y + pos[i][1];
            if (isIn(px, py)) {
                if (!check[px][py]) {
                    if (rg) {
                        if (field[x][y] == field[px][py])
                            dfs(px, py, rg);
                    } else {
                        if ((field[x][y] > 0 && field[px][py] > 0))
                            dfs(px, py, rg);
                        else if (field[x][y] == 0 && field[px][py] == 0)
                            dfs(px, py, rg);
                    }
                }
            }
        }
    }
}