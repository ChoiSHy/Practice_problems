package Programmers.Multi_level_Toothbrush_Sales;
// enroll : 각 판매원의 이름
// referral : i번쨰 판매원을 참가시킨 사람 이름
// seller : amount의 판매 주체
// amount : 판매량 집계
// 칫솔 한 개의 수익은 100원이다.

import java.util.HashMap;

class Solution {
    HashMap<String, Integer> nameIdx;
    int[] union;
    int[] result;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        set(enroll, referral);
        int len = seller.length;
        for (int i = 0; i < len; i++) {
            calc(nameIdx.get(seller[i]), amount[i] * 100);
        }
        return result;
    }

    void calc(int seller, int amount) {
        int payment = amount / 10;
        if (payment < 1)
            result[seller] += amount;

        else {
            int ownMoney = amount - payment;

            result[seller] += ownMoney;
            if (union[seller] != -1) {
                calc(union[seller], payment);
            }
        }
    }

    void set(String[] enroll, String[] referral) {
        int len = enroll.length;
        nameIdx = new HashMap<>();
        union = new int[len];
        result = new int[len];

        nameIdx.put("-", -1);
        for (int i = 0; i < len; i++)
            nameIdx.put(enroll[i], i);

        for (int i = 0; i < len; i++)
            union[i] = nameIdx.get(referral[i]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10});
        s.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4});
    }
}