package Bakjun.N1693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int n, maximum=987654321;
    static int maxColors = 18;      // n개의 색을 칠할 때, 필요한 트리의 최소 크기는 2^(N-1) -> 트리의 최대 크기는 100,000 이므로 log2(100,000) = 16.xxx = 17
                                    // 반복문 최대 범위 지정용이기 때문에 +1해서 18로 설정
    static List<Integer>[] adjList; // 입력값을 저장할 그래프
    static List<Integer>[] tree;    // 입력 그래프를 정제할 트리
    static int[][] dp;              // 동적 계산을 위한 dp 필드
    public static void main(String[] args) throws IOException {
        /* 입력 및 선언 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new List[n + 1];
        tree = new List[n + 1];

        for (int i = 1; i < n+1; i++) {
            adjList[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            /* 그래프에 입력값 넣기 */
            adjList[a].add(b);
            adjList[b].add(a);
        }
        makeTree(1,-1); // 입력받은 그래프를 트리로 정제화

        dp = new int[n+1][maxColors];
        for(int i=1;i<n+1;i++)
            Arrays.fill(dp[i], -1); // dp 안에는 -1로 채움

        int res= maximum;      // 결과는 최댓값으로
        for(int i =1;i<maxColors;i++)
            res = Math.min(res, paint(1,i));    // 특정 노드에 특정 색을 칠했을 때의 결과와 비교해 작은 값을 결과로 선택
        System.out.println(res);
    }

    static void makeTree(int idx, int parent) {
        for (int next : adjList[idx]) {
            if (next != parent) {   // 해당 노드의 부모를 제외하고 넣기
                tree[idx].add(next);
                makeTree(next, idx);
            }
        }
    }

    static int paint(int cur, int color) {
        if (dp[cur][color] != -1) return dp[cur][color];    // 이미 칠한 색이면 넘어가기

        dp[cur][color]=0;   // 일단은 방문 흔적 남기기
        for(int next: tree[cur]){   // 현재 노드의 모든 자식 노드 접근
            int tmp = maximum;
            for(int i=1;i<maxColors;i++){
                if(color != i)      // 현재 노드에 칠해진 색을 제외한 색들을 자식 노드에 칠해보기
                    tmp= Math.min(tmp, paint(next, i));     // 그렇게 해서 나온 결과들 중에 최소값을 tmp에 저장
            }
            dp[cur][color] += tmp;  // 현재 결과를 dp에 저장
        }
        return dp[cur][color] += color; // 현재 노드에서 볼 일 끝나면 자신의 색에 대한 비용을 추가하고 리턴
    }
}
