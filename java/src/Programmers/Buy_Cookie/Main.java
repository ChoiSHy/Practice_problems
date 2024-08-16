package Programmers.Buy_Cookie;

/*
 * 과자를 바구니 단위로 파는 가게가 있습니다. 이 가게는 1번부터 N번까지 차례로 번호가 붙은 바구니 N개가 일렬로 나열해 놨습니다.
 * 철수는 두 아들에게 줄 과자를 사려합니다. 첫째 아들에게는 l번 바구니부터 m번 바구니까지, 둘째 아들에게는 m+1번 바구니부터 r번 바구니까지를 주려합니다.
 * 단, 두 아들이 받을 과자 수는 같아야 합니다(1 <= l <= m, m+1 <= r <= N). 즉, A[i] 를 i번 바구니에 들어있는 과자 수라고 했을 때, A[l]+..+A[m] = A[m+1]+..+A[r] 를 만족해야 합니다.
 * 각 바구니 안에 들은 과자 수가 차례로 들은 배열 cookie가 주어질 때,
 * 조건에 맞게 과자를 살 경우 한 명의 아들에게 줄 수 있는 가장 많은 과자 수를 return 하는 solution 함수를 완성해주세요. (단, 조건에 맞게 과자를 구매할 수 없다면 0을 return 합니다)
 *
 * (l ~ m) == (m+1 ~ r) { 0 <= l <=m <= r <= N }
 * */


class Solution {

    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;
        int left, right;    // 위에서 l, r에 해당
        int lsum, rsum;     // 두 형제가 각자 가지는 과자 개수

        for (int i = 0; i < n - 1; i++) {
            left = i;
            right = i + 1;
            lsum = cookie[left];
            rsum = cookie[right];
            //System.out.printf("=== %d - %d\t lsum= %d, rsum= %d\n",left, right, lsum,rsum);

            // 더 적은 과자를 가진 아들에게 과자 하나 더 주기. 더 줄 과자가 없다면 다음 기준으로 이동.
            while (left >= 0 && right <= n - 1) {
                if (lsum < rsum && left > 0)
                    lsum += cookie[--left];
                else if (lsum > rsum && right < n - 1)
                    rsum += cookie[++right];
                else if(lsum == rsum){ // 시작하자마자 과자 개수가 같은 경우
                    answer = Math.max(answer, lsum);
                    if(left > 0)
                        lsum += cookie[--left];
                    else if (right< n-1)
                        rsum += cookie[++right];
                    else break; // 더 이상 줄 과자가 없는 경우
                }
                else break; // 더 이상 줄 과자가 없는 경우
                
                if (lsum == rsum) {
                    answer = Math.max(answer, lsum);    // 두 아들이 가지는 과자의 개수가 같아지면 현재 정답과 비교해 큰 값으로 교체
                }
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 1, 2, 3});
        s.solution(new int[]{1, 2, 4, 5});
        s.solution(new int[]{1, 1, 2, 3, 1, 1, 4, 2, 3});
        s.solution(new int[]{1, 250, 1, 250, 500, 500});
    }
}
