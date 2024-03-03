package Programmers.JavaCodingTest.p7_Greedy;

import java.util.Scanner;

public class GreedyTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int cnt = 0;
        while(n > 1){
            if(n % k == 0){
                n /= k;
                cnt++;
            }
            else {
                n--;
                cnt++;
            }
        }
        System.out.println("answer: "+cnt);
    }
}
