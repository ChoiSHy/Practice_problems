package Programmers.Entry_screen;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        long res=s.solution(1000000000, new int[]{
                1, 1000000000
        });

        System.out.println(res);
    }
}
class Solution {
    int[] times;
    long left;
    long right;
    public long solution(int n, int[] times) {
        this.times = times;
        Arrays.sort(this.times);
        left =  (long)times[0];
        right = (long)n * (long)times[times.length-1];


        long answer = Long.MAX_VALUE;
        long mid;
        while(left <= right){
            //System.out.println(String.format("[%d] ~ [%d]",left,right));
            mid = (left + right)/2;

            if(howManyWork(n, mid)){
                right = mid-1;
                answer = Math.min(mid, answer);
            }
            else{
                left=mid+1;
            }
        }

        return answer;
    }
    boolean howManyWork(int people, long answer){
        long howManyPeople = 0;
        for(int time : times){
            howManyPeople += (answer / time);
        }
        if(howManyPeople < people)
            return false;
        return true;
    }
}