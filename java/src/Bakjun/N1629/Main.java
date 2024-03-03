package Bakjun.N1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long a, b, c;
    static long one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        a = Long.parseLong(inputs[0]);
        b = Long.parseLong(inputs[1]);
        c = Long.parseLong(inputs[2]);
        one = a % c;
        long res = getMod(b);
        System.out.println(res);
    }

    static long getMod(long n) {
        if (n == 0) return 1;
        else if (n == 1) return one;

        long mod = getMod(n / 2) % c;
        if (n % 2 == 1)
            return ((mod * mod)%c * one) % c;
        else
            return (mod * mod) % c;
    }
}
