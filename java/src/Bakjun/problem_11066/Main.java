package Bakjun.problem_11066;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] spl = null;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int[] val = new int[k+1];
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];

            spl = br.readLine().split(" ");
            for (int j = 1; j <= k; j++) {
                val[j] = Integer.parseInt(spl[j-1]);
                sum[j] = (sum[j - 1] + val[j]);
            }
            for (int n = 1; n <= k; n++) {
                for (int from = 1; from + n <= k; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int div = from; div < to; div++) {
                        dp[from][to] = Math.min(
                                dp[from][to],
                                dp[from][div] + dp[div + 1][to] + sum[to] - sum[from-1]
                        );
                    }
                }
            }
            bw.write(dp[1][k] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
