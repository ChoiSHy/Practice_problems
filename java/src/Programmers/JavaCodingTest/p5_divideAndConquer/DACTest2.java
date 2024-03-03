package Programmers.JavaCodingTest.p5_divideAndConquer;

import java.util.*;

public class DACTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();


        Solution2 s2 = new Solution2(n, k);
        s2.solve(k, 1);
    }
}

class Solution2 {
    Stack<Integer> stack;
    List<Integer[]> answer;
    int n, k;

    public Solution2(int n, int k) {
        this.n = n;
        this.k = k;
        stack = new Stack<>();
        answer = new ArrayList<>();

    }

    public void solve(int k, int start) {
        if (k == 0){
            answer.add(stack.toArray(new Integer[this.k]));
        }
        else{
            for(int i = start;i<=n;i++){
                stack.push(i);
                solve(k-1,i+1);
                stack.pop();
            }
        }
    }
}
