package Programmers.JavaCodingTest.p7_Greedy;

import java.util.Scanner;

public class GreedyTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int answer=input.charAt(0)-'0';
        for(int i =1;i<input.length();i++){
            int n = input.charAt(i) - '0';
            if(answer * n == 0 || answer * n == answer)
                answer += n;
            else answer *= n;
        }
        System.out.println("answer : "+answer);
    }
}
