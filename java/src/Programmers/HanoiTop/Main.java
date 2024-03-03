package Programmers.HanoiTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        for(int[] ans : s1.solution(2))
            System.out.println(String.format("%d -> %d",ans[0],ans[1]));
        System.out.println();
        for(int[] ans : s1.solution(3))
            System.out.println(String.format("%d -> %d",ans[0],ans[1]));
        System.out.println();
        for(int[] ans : s1.solution(4))
            System.out.println(String.format("%d -> %d",ans[0],ans[1]));

    }
}

class Solution{
    List<int[]> log;
    public int[][] solution(int n){
        log=new ArrayList<>();

        move(n, 1, 3, 2);

        int answer[][]= new int[log.size()][2];
        for(int i=0;i<log.size();i++) {
            answer[i][0] = log.get(i)[0];
            answer[i][1] = log.get(i)[1];
        }
        return answer;
    }
    public void move(int n, int from, int to, int via){
        if(n == 1){
            log.add(new int[]{from, to});
        }
        else{
            move(n-1, from, via, to);
            log.add(new int[]{from, to});
            move( n-1, via, to, from);
        }
    }
}
