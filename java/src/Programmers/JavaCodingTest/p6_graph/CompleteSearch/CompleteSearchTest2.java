package Programmers.JavaCodingTest.p6_graph.CompleteSearch;

import java.util.Scanner;

public class CompleteSearchTest2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        boolean[][] field = new boolean[n][m];
        for(int i = 0 ; i<n;i++){
            String input= scanner.nextLine();
            char[] chars = input.toCharArray();
            for(int j = 0;j<m;j++){
                field[i][j] = chars[j]=='0' ? true : false;
            }
        }
        for(int i = 0 ; i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print((field[i][j] ? 0 : 1)+"\t");
            }
            System.out.println();
        }

        Solution s = new Solution(n,m,field);
        System.out.println("answer: "+s.solve());
    }

}
class Solution{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1, 0,-1};
    int n ,m;
    boolean[][] field;

    public Solution(int n, int m, boolean[][] field){
        this.n=n;
        this.m=m;
        this.field= field;
    }
    public int solve(){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j ++){
                if(field[i][j]){
                    dfs(i,j);
                    cnt ++;
                }
            }
        }
        return cnt;
    }
    private void dfs (int x, int y){
        if(field[x][y]){
            field[x][y] = false;
            for(int i = 0 ; i<4;i++){
                if(outCheck(x+dx[i], y+dy[i]))
                    dfs(x+dx[i], y+dy[i]);
            }
        }
    }
    private boolean outCheck(int x, int y){
        if(0<= x && x < n && 0 <= y && y < m)
            return true;
        return false;
    }
}
