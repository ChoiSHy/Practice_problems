package Programmers.JavaCodingTest.p1_BitTest.p3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};
        int[] res = new int[n];
        String[] answer = new String[n];
        for(int i = 0;i<n;i++) {
            res[i] = (arr1[i]|arr2[i]);
            for(int j = n-1;j>=0;j--)
            System.out.println(answer[i]);
        }


        System.out.println();
    }
}
