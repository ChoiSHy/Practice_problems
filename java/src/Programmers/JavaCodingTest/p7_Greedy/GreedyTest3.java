package Programmers.JavaCodingTest.p7_Greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b)->
            a[1]-b[1]
        );

        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] route : routes)
            queue.add(route);
        int cam = routes[0][1];
        int answer = 1;
        while(!queue.isEmpty()){
            int[] car = queue.remove();
            if(cam< car[0] || car[1] < cam){
                cam = car[1];
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
public class GreedyTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] routes = new int[n][2];
        for(int i = 0 ; i< n; i ++){
            routes[i][0] = scanner.nextInt();
            routes[i][1] = scanner.nextInt();
        }
        Solution s = new Solution();
        s.solution(routes);

    }
}
