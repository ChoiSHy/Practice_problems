package Programmers.Rank;

import java.util.*;
/*
 *
 * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
 * 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
 * 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
 * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * [A, B]라면 A가 승리, B가 패배한 것이다.
 * */
class Solution {
    int[][] adj;
    static int INF = 999;

    public int solution(int n, int[][] results) {
        int answer = 0;

        // 인접 행렬 생성
        adj = new int[n + 1][n + 1];
        Arrays.stream(adj).forEach(
                arr -> Arrays.fill(arr, INF));
        Arrays.stream(results).forEach(res ->
            adj[res[1]][res[0]] = 1
        );
        // 플루이드-워셜 알고리즘 이용해, 각 선수간 승패여부 구하기
        for (int via = 1; via < n + 1; via++) {
            for (int i = 1; i < n + 1; i++) {
                if (via == i) continue;
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) continue;
                    if (adj[i][via] == 1 && adj[via][j] == 1)
                        adj[i][j] = 1;
                }
            }
        }
        // 승패 정보가 n-1개 존재한다면, 해당 선수의 순위는 확정
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < n + 1; j++)
                if (adj[i][j] == 1) {
                    res[i]++;
                    res[j]++;
                }
        for (int i = 1; i < n + 1; i++)
            if (res[i] == n - 1) answer++;
        return answer;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }
}

