package Programmers.BestSet;

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int m = s / n;
        System.out.println(String.format("n: %d,\ts: %d,\tm: %d",n,s,m));
        int[] answer;
        if(m == 0){
            answer = new int[]{-1};
           print(answer);
            return answer;
        }
        answer = new int[n];

        Arrays.fill(answer,m);
        int sum = 0;
        int idx=n-1;
        for(int e : answer) sum += e;

        while(sum != s){
            answer[(idx--)%n] +=1;
            sum++;
        }
        print(answer);
        return answer;
    }
    void print(int[] answer){
        System.out.print("answer: [\t");
        Arrays.stream(answer).forEach(e-> System.out.print(e+"\t"));
        System.out.println("]");
        System.out.println("-------------------------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(2,9);
        s.solution(2,1);
        s.solution(2,8);
        s.solution(3,10);
        s.solution(3,9);

    }
}
