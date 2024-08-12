package Programmers.CountDown;

/*
 * 1 ~ 20 까지의 과녁이 존재
 * 점수는 싱글, 더블, 트리플
 * 불: 50점
 *
 * <승리 조건>
 * 더 적은 라운드를 소모하면 승리
 * 같은 라운드면 싱글/불 개수가 많을 수록 승리
 * */


class Solution {
    int[][] dp;

    public int[] solution(int target) {

        dp = (target < 60) ? new int[61][2] : new int[target + 1][2];
        for (int i = 1; i <= 20; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            if (dp[i * 2][0] != 1)
                dp[i * 2][0] = 1;
            if (dp[i * 3][0] != 1)
                dp[i * 3][0] = 1;
        }
        dp[50][0] = 1;
        dp[50][1] = 1;

        // 23 ~ 60 중에서 두 번만에 가야 하는 값들
        for (int i = 23; i <= 60; i++) {
            if (dp[i][0] == 0) {
                dp[i][0] = 2;
                for (int j = 1; j < 20; j++) {
                    if (dp[i - j][0] + 1 <= dp[i][0]) {      // 더한 값이 현재 총합보다 적을 경우
                        dp[i][1] = Math.max(dp[i - j][1] + 1, dp[i][1]);
                    }
                }
            }
        }

        if (target > 60) {
            for (int i = 61; i <= target; i++) {
                // 50으로 자를 떄, 더 횟수가 적은 경우
                if (dp[i - 60][0] > dp[i - 50][0]) {
                    dp[i][0] = dp[i - 50][0] + 1;
                    dp[i][1] = dp[i - 50][1] + 1;
                }
                // 60으로 자를 떄, 더 횟수가 적은 경우
                else if (dp[i - 60][0] < dp[i - 50][0]) {
                    dp[i][0] = dp[i - 60][0] + 1;
                    dp[i][1] = dp[i - 60][1];
                }
                // 총 횟수가 똑같을 떄, 싱글/불이 더 많은 경우
                else {
                    dp[i][0] = dp[i - 50][0] + 1;
                    // 50으로 자를 떄가 유리하면 싱글/불 개수를 증가하는 경우와 비교
                    dp[i][1] = Math.max(dp[i - 50][1] + 1, dp[i - 60][1]);
                }

            }
        }

        // { (총합), (싱글/불) }
        System.out.println("총합: " + dp[target][0] + "\t싱글/불: " + dp[target][1]);
        return dp[target];
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();


        s.solution(20);
        s.solution(294);
        s.solution(60);
        s.solution(58);
        s.solution(29);

    }
}
