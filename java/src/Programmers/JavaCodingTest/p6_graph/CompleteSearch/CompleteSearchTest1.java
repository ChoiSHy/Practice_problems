package Programmers.JavaCodingTest.p6_graph.CompleteSearch;

import java.util.Scanner;

/*
* DFS : 빠른 탐색
* BFS : 최단 거리 찾기 가능
*
* 선택된 edge는 신장 트리 구성
* */
public class CompleteSearchTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int cnt = 0;
        int[] nums = new int[n];
        for(int i = 0 ; i<n;i++){
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int size = (int)Math.pow(2, n+1)-1;
        System.out.println("size: "+size);
        int[] result = new int[size];
        int idx= 0;

        for(int i = 2 ; i<size ; i++){
            System.out.println(String.format("i: %d, idx: %d",i,idx));
            int prev = result[i/2];
            if(i%2 ==0)
                result[i] = prev + nums[idx];
            else
                result[i] = prev - nums[idx];
            if(i==Math.pow(2, idx+2))
                idx++;
        }
        for(int i = (int)Math.pow(2,n);i<size;i++)
            if(i == k)
                cnt ++;

        System.out.println(cnt);

    }
}
