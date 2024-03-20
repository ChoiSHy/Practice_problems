package Programmers.DoublePriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
* 이중우선순위큐
*
* 최대힙과 최소힙을 사용해 최댓값과 최솟값을 제거하는 기능 만들기
* */
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        for(String operation : operations){
            String[] ops = operation.split(" ");
            char op = ops[0].charAt(0);
            int n = Integer.parseInt(ops[1]);
            switch (op){
                case 'I':
                    minHeap.add(n);
                    maxHeap.add(n);
                    break;
                case 'D':
                    if(minHeap.isEmpty()) continue;
                    if(n>0)
                        minHeap.remove(maxHeap.remove());
                    else
                        maxHeap.remove(minHeap.remove());
                    break;
            }
            System.out.println(String.format("%c %10d\t%s",op,n,minHeap));

        }
        if(minHeap.size() == 0)
            return new int[]{0,0};
        return new int[]{maxHeap.remove(), minHeap.remove()};
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result;
        result=s.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        Arrays.stream(result).forEach(e-> System.out.print(e+" "));
        System.out.println();
        result=s.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        Arrays.stream(result).forEach(e-> System.out.print(e+" "));
        System.out.println();
    }
}
