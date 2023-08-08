package N11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] p;
        int[] s;
        try {
            n = Integer.parseInt(br.readLine());
            p = new int[n];
            s = new int[n];
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(inputs[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Arrays.sort(p);
        s[0] = p[0];
        for (int i = 1; i < n; i++)
            s[i] = s[i-1] + p[i];

        int sum = 0;
        for (int i: s)
            sum+= i;
        System.out.println(sum);
    }
}
