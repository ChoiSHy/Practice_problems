package Programmers.JavaCodingTest.p4_Array;

import java.util.Scanner;

public class ArrayTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] answer = solve(n);

        for (int[] arr : answer) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

    }

    static int[][] solve(int n) {
        int[][] pyramid = new int[n][];
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        for (int i = 0; i < n; i++)
            pyramid[i] = new int[i + 1];
        int limit = (1 + n) * n / 2;

        int i = 1;
        int way = 0;
        int d = n;
        int x = -1, y = 0;
        while (i <= limit) {
            for(int j = 0 ;j<d;j++){
                x += dx[way];
                y += dy[way];
                pyramid[x][y] = i++;
            }
            way = (way+1)%3;
            d--;
        }
        return pyramid;
    }
}
