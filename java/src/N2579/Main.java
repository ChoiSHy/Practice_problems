package N2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];

        for (int i = 0; i < n; i++)
            stairs[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[n];

        dp[0] = stairs[0];                                                  // 0 -> 1
        if(n>1)
            dp[1] = Math.max(stairs[1], stairs[0] + stairs[1]);             // 0 -> 1 -> 2 or 0 -> 2
        if(n>2)
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]); // 0 -> 1 -> 3 or 0 -> 2 -> 3
        /*
         dp[i] 가 i-1계단까지의 최댓값이라 할 때

         dp[i] =
         dp[i-2] + stairs[i]                  (i-2 까지의 최댓값) + (i)
         dp[i-3] + stairs[i-1] + stairs[i]    (i-3 까지의 최댓값) + (i-1) + (i)
         둘 중 큰 값
        */

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }
        System.out.println(dp[n - 1]);
    }

}
