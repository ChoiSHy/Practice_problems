package Programmers.JavaCodingTest.p5_divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class DACTest1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        for(int[] a : s.solution(3))
            System.out.println(a[0]+" "+ a[1]);
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
