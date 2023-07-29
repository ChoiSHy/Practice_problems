package N11444;

import java.util.Scanner;

public class Main {
    static long[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        fibonacci(n);
        System.out.println((int)matrix[0][1]);
    }

    static void fibonacci(long n) {
        if (n == 1) {
            matrix = new long[][]{{1L, 1L}, {1L, 0L}};
            return;
        }
        if (n % 2 == 0) {
            fibonacci(n/2);
            multi(true);
        }
        else {
            fibonacci(n/2);
            multi(true);
            multi(false);
        }
    }

    static void multi(boolean x) {
        Long a = 0L, b = 0L, c = 0L, d = 0L;
        if (x) {
            a = (matrix[0][0] * matrix[0][0] + matrix[0][1] * matrix[1][0]) % 1000000007;
            b = (matrix[0][0] * matrix[0][1] + matrix[0][1] * matrix[1][1]) % 1000000007;
            c = (matrix[1][0] * matrix[0][0] + matrix[1][1] * matrix[1][0]) % 1000000007;
            d = (matrix[1][0] * matrix[0][1] + matrix[1][1] * matrix[1][1]) % 1000000007;
        } else {
            a = (matrix[0][0] + matrix[0][1]) % 1000000007;
            b = (matrix[0][0]) % 1000000007;
            c = (matrix[1][0] + matrix[1][1]) % 1000000007;
            d = (matrix[1][0]) % 1000000007;
        }
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }
}
