package Programmers.Overtime_Index;

import java.util.*;

/* 야근 지수
*
*회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
* 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
* Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
* Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
* 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
*
* 야근 피로도 = ( 남은 작업량 )^2 의 합
* 시간당 작업량 = 1
*
* */
class Solution {
    public long solution(int[] works, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(works).forEach(e->heap.add(e));

        for(int i =0;i<n;i++){
            int k = heap.remove();
            if(k == 0) break;
            heap.add(k-1);
        }
        //System.out.println(heap);
        long answer = heap.stream().mapToLong(i->i*i).sum();
        System.out.println(answer);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{4, 3, 3}, 4);
        s.solution(new int[]{2, 1, 2}, 1);
        s.solution(new int[]{1, 1}, 3);
    }
}
