package N1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        String[] inputs;
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            dp[i][0] = Integer.parseInt(inputs[0]);
            dp[i][1] = Integer.parseInt(inputs[1]);
            dp[i][2] = Integer.parseInt(inputs[2]);
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i][0] + dp[i - 1][1], dp[i][0] + dp[i - 1][2]);
            dp[i][1] = Math.min(dp[i][1] + dp[i - 1][0], dp[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(dp[i][2] + dp[i - 1][0], dp[i][2] + dp[i - 1][1]);
        }

        int min = dp[n-1][0];
        if(min > dp[n-1][1])
            min = dp[n-1][1];
        if(min > dp[n-1][2])
            min = dp[n-1][2];

        System.out.println(min);

    }
}
