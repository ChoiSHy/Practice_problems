package Bakjun.N14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static int n, m;
    static int[][] field;
    static boolean[][] visited;
    static int[][] pos = new int[][]{
            {1, -1, 0, 0},
            {0, 0, 1, -1}
    };

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        testSet();
        bfs();
        for (int i =0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(visited[i][j])
                    System.out.print(field[i][j]+" ");
                else
                    System.out.print("-1 ");
            }
            System.out.println();
        }
    }

    public static void testSet() {
        try {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            m=Integer.parseInt(inputs[1]);
            field=new int[n][m];
            visited=new boolean[n][m];

            for(int i=0;i<n;i++){
                inputs = br.readLine().split(" ");
                for(int j = 0 ; j<m;j++){
                    field[i][j] = Integer.parseInt(inputs[j]);
                    if(field[i][j] == 2){
                        queue.add(new int[]{i,j});
                        field[i][j] = 0;
                    }
                    else if( field[i][j] == 0)
                        visited[i][j] =true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void bfs() {
        int[] curPos = queue.poll();
        int x, y;
        visited[curPos[0]][curPos[1]]=true;
        for (int i = 0; i < 4; i++) {
            x = curPos[0] + pos[0][i];
            y = curPos[1] + pos[1][i];

            if (0 <= x && x < n && 0 <= y && y < m && field[x][y] != 0) {
                queue.add(new int[]{x, y});
            }
        }
        while (!queue.isEmpty()) {
            curPos = queue.poll();
            visited[curPos[0]][curPos[1]] = true;
            for (int i = 0; i < 4; i++) {
                x = curPos[0] + pos[0][i];
                y = curPos[1] + pos[1][i];

                if (0 <= x && x < n && 0 <= y && y < m) {
                    if (!visited[x][y] && field[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        field[x][y] = field[curPos[0]][curPos[1]] + 1;
                    }
                }
            }
        }
    }
}
