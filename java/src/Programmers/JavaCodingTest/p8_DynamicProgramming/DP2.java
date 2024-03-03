package Programmers.JavaCodingTest.p8_DynamicProgramming;

import java.util.Scanner;
class Solution {
    int[][] dp;
    int[][]tri;
    int n;
    public int solution(int[][] tri) {
        setting(tri);
        for(int i= 1;i<n;i++){
            dp[i][0] = dp[i-1][0] + tri[i][0];
            for(int j = 1 ;j<i;j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+ tri[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + tri[i][i];
        }
        print();
        int answer = 0;
        for(int i : dp[n-1]){
            if(i > answer)
                answer = i;
        }
        return answer;
    }
    void print(){
        for(int[] flr : dp){
            for (int i : flr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
    void setting(int[][] tri){
        this.tri = tri;
        n = tri.length;
        dp = new int[n][];

        for(int i = 0; i< n;i++)
            dp[i] = new int[i+1];
        dp[0][0] = tri[0][0];
    }
}

public class DP2 {
    public static void main(String[] args) {
        int[][] tri = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}};
        
        Solution s = new Solution();
        System.out.println("answer: "+s.solution(tri));

    }
}
