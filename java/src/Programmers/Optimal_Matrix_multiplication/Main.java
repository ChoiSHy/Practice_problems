package Programmers.Optimal_Matrix_multiplication;

/*
 다시 풀어볼 것!!
 * */
class Solution {
    int[][] dp;
    int[][] mat;
    public int solution(int[][] m) {
        int len = m.length;
        dp = new int[len + 1][len + 1];
        this.mat=m;
        int answer = mul(0,len);
        System.out.println(answer);
        return answer;
    }

    private int mul(int s, int e) {
        /* 행렬 자체는 계산 x */
        if (e - s == 1) return 0;

        int ret = Integer.MAX_VALUE;

        for (int m = s + 1; m < e; m++){  // s < m < e
            int left = mulDP(s,m);        // [s, m)
            int right = mulDP(m,e);       // [m, e)
            int cur = mat[s][0] * mat[m][0] * mat[e-1][1];
            ret = Math.min(ret, left+right+cur);
        }
        return ret;
    }
    private int mulDP(int s, int e){
        if(dp[s][e] == 0 )
            dp[s][e] = mul(s, e);
        return dp[s][e];
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{5,3},{3,10},{10,6}});
        s.solution(new int[][]{{5, 3}, {3, 10}, {10, 6}, {6, 5}});
        s.solution(new int[][]{{4, 5}, {5, 10}, {10, 7}, {7, 3}});
    }
}
