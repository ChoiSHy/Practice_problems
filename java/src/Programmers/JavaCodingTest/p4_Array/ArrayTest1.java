package Programmers.JavaCodingTest.p4_Array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayTest1 {
    public static void main(String[] args) {
        Random random = new Random(0);
        Scanner scanner = new Scanner(System.in);
        int n = 100000;
        System.out.print("k? ");
        int k = scanner.nextInt();
        int[] A = new int[n];
        for(int i = 0 ; i<n;i++){
            A[i]= random.nextInt(-1000000,1000000);
        }

        find1(A,k);
        find2(A,k);

    }
    static void find1(int[] A, int k){
        double start = System.currentTimeMillis();
        Arrays.sort(A);

        int minIdx=0, maxIdx=A.length-1;
        int count = 0;
        while(minIdx != maxIdx){
            int min = A[minIdx];
            int max = A[maxIdx];
            int sum = min+max;
            if(sum == k){
                System.out.printf("(%d, %d) = %d\n", min, max, sum);
                minIdx++;
                maxIdx--;
            }
            else if(sum < k){
                minIdx++;
            }
            else{
                maxIdx--;
            }
            count++;
        }
        double end = System.currentTimeMillis();
        System.out.println("소요 시간: "+(end - start));
    }
    static void find2(int[] A, int k){
        double start = System.currentTimeMillis();
        for(int i =0;i<A.length;i++){
            for(int j = i;j<A.length;j++){
                if(A[i] + A[j] == k)
                    System.out.printf("(%d, %d)\n", A[i],A[j]);
            }
        }
        double end = System.currentTimeMillis();

        System.out.println("소요시간: "+(end-start));
    }
}
