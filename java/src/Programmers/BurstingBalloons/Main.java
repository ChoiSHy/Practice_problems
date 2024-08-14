package Programmers.BurstingBalloons;


/*
일렬로 나열된 n개의 풍선이 있습니다. 모든 풍선에는 서로 다른 숫자가 써져 있습니다. 당신은 다음 과정을 반복하면서 풍선들을 단 1개만 남을 때까지 계속 터트리려고 합니다.

임의의 인접한 두 풍선을 고른 뒤, 두 풍선 중 하나를 터트립니다.
터진 풍선으로 인해 풍선들 사이에 빈 공간이 생겼다면, 빈 공간이 없도록 풍선들을 중앙으로 밀착시킵니다.
여기서 조건이 있습니다. 인접한 두 풍선 중에서 번호가 더 작은 풍선을 터트리는 행위는 최대 1번만 할 수 있습니다. 즉, 어떤 시점에서 인접한 두 풍선 중 번호가 더 작은 풍선을 터트렸다면, 그 이후에는 인접한 두 풍선을 고른 뒤 번호가 더 큰 풍선만을 터트릴 수 있습니다.

당신은 어떤 풍선이 최후까지 남을 수 있는지 알아보고 싶습니다. 위에 서술된 조건대로 풍선을 터트리다 보면, 어떤 풍선은 최후까지 남을 수도 있지만, 어떤 풍선은 무슨 수를 쓰더라도 마지막까지 남기는 것이 불가능할 수도 있습니다.

일렬로 나열된 풍선들의 번호가 담긴 배열 a가 주어집니다. 위에 서술된 규칙대로 풍선들을 1개만 남을 때까지 터트렸을 때 최후까지 남기는 것이 가능한 풍선들의 개수를 return 하도록 solution 함수를 완성해주세요.*/
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[][] mins = setMins(a);

        for (int i = 0; i < a.length; i++) {
            int leftMin = i > 0 ? mins[0][i - 1] : a[i];
            int rightMin = i < a.length-1 ? mins[1][i] : a[a.length - 1];
            int count = 0;
            if (leftMin < a[i]) count++;
            if (rightMin < a[i]) count++;
            if (count <= 1) answer++;
        }
        return answer;
    }
    int[][] setMins(int[] a) {
        int len = a.length;
        int[][] ret = new int[2][len];
        ret[0][0] = a[0];
        ret[1][len - 1] = a[len - 1];

        for (int i = 1; i < a.length; i++) {
            ret[0][i] = Math.min(ret[0][i - 1], a[i]);
            ret[1][len - i - 1] = Math.min(ret[1][len - i], a[len - i - 1]);
        }
        return ret;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{9, -1, -5});
        s.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33});
    }
}
