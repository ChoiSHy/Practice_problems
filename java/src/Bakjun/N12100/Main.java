package Bakjun.N12100;

import java.util.Scanner;

class Board {
    int n;
    int cnt;
    int max = 0;
    int[][] board;

    public Board(int n, Scanner scan) {
        this.n = n;
        this.cnt=0;
        board = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++){
                board[i][j] = scan.nextInt();
                if(board[i][j]!=0)cnt++;
                if(max<board[i][j]) max=board[i][j];
            }
        scan.close();
    }
    public Board(Board b){
        this.n=b.n;
        this.max=b.max;
        this.cnt=b.cnt;
        this.board= new int [n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                this.board[i][j] = b.board[i][j];
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
        System.out.println("max: " + max);

    }

    public int move(int way) {
        switch (way) {
            case 0: //up
                for (int j = 0; j < n; j++)
                    move(0, j, 1, 0);
                break;
            case 1: //right
                for (int i = 0; i < n; i++)
                    move(i, n - 1, 0, -1);
                break;
            case 2: //down
                for (int j = 0; j < n; j++)
                    move(n - 1, j, -1, 0);
                break;
            case 3: //left
                for (int i = 0; i < n; i++)
                    move(i, 0, 0, 1);
                break;
        }
        return max;
    }

    private void move(int i, int j, int ver, int hor) {
        if (ver == 0) {
            if (hor < 0 ? j == 0 : j == n - 1)
                return;
        } else if (hor == 0) {
            if (ver > 0 ? i == n - 1 : i == 0)
                return;
        }
        int v = find(i + ver, j + hor, board[i][j], ver, hor);

        if (v == board[i][j]) {
            board[i][j] += v;
            if (max < board[i][j]) max = board[i][j];
        }
        else if (board[i][j] == 0) {
            board[i][j] += v;
            i -= ver;
            j -= hor;
        }
        move(i + ver, j + hor, ver, hor);
    }
    private int find(int i, int j, int src, int ver, int hor) {

        if ((hor == 0 && (i == 0 || i == n - 1)) || ver == 0 && (j == 0 || j == n - 1) || board[i][j] != 0) {
            int ret = board[i][j];
            if (board[i][j] == src || src == 0) {
                board[i][j] = 0;
                cnt--;
            }
            return ret;
        } else
            return find(i + ver, j + hor, src, ver, hor);
    }
}

public class Main {
    static int n = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        Board board = new Board(n, scan);

        int res = simulator(board, 0);
        System.out.println(res);
    }
    static int simulator(Board board, int dep){
        if(dep>=5 || board.cnt==1)
            return board.max;
        int max = board.max;
        Board[] blist = new Board[4];
        for(int i=0;i<4;i++){
            blist[i]=new Board(board);
            blist[i].move(i);
            int res = simulator(blist[i], dep+1);
            max = max < res ? res : max;
        }

        return max;

    }
}