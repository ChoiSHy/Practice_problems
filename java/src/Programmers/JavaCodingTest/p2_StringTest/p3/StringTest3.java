package Programmers.JavaCodingTest.p2_StringTest.p3;

import java.util.Scanner;

public class StringTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        System.out.println(solve2(str1, str2));
    }
    static boolean solve1(String str1,String str2){
        // rotation 시도
        return false;
    }
    static boolean solve2(String str1,String str2){
        String s1 = str1.concat(str1);

        return s1.contains(str2);
    }
}
