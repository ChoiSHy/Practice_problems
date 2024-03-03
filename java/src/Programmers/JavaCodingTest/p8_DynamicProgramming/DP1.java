package Programmers.JavaCodingTest.p8_DynamicProgramming;

import java.util.Scanner;

public class DP1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i] = scanner.nextInt();

        for(int i = 2 ; i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
        }
        System.out.println(dp[n-1]);
    }
}
/*
    4
    1 3 1 5
    =8

    4
    1 2 3 1
    =4

    5
    2 7 9 3 1
    =12
*/
