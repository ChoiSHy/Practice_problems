package Programmers.JavaCodingTest.p1_BitTest.p2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*
        int p = scanner.nextInt();
        int q = scanner.nextInt();

        int x = scanner.nextInt();
        int y = scanner.nextInt();*/
        int p = 4914;
        int q = 63;
        int x = 4;
        int y = 9;

        int mask = (1 << (y-x+1))-1;
        int answer = (q & ~(mask << x)) | (p <<x);
        System.out.println(Integer.toBinaryString(p));
        System.out.println(Integer.toBinaryString(q));
        System.out.println(Integer.toBinaryString(answer));


    }
}
