package Programmers.JavaCodingTest.p6_graph.CompleteSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTest {
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
    }
}
class Solution2{
    int n,m;
    int[][] field;
    Queue<int[]> queue;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1, 0,-1};
    public int solution(int n , int m, int[][] maps){
        this.n=n;this.m=m;
        field = maps;
        queue = new LinkedList<>();

        int answer = 0;
        return answer;
    }
    void bfs(int x, int y){
        boolean[][] visit = new boolean[n][m];
        queue.add(new int[]{x,y});
        int val = 1;
        while(!queue.isEmpty()){
            int[] pos = queue.remove();
            for(int i = 0 ; i<4;i++){
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(outCheck(nx, ny) && !visit[nx][ny]){
                    queue.add(new int[]{nx,ny});
                    if(field[nx][ny] > val || field[nx][ny] ==1)
                        field[nx][ny]= val;
                }
            }
        }
    }
    boolean outCheck(int x, int y){
        if(0<=x && x < n && 0 <= y && y <m && field[x][y] == 1 )
            return true;
        return false;
    }
}
