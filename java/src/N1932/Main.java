package N1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] datas;
        int n;
        String[] inputs;
        try {
            n = Integer.parseInt(br.readLine());
            datas = new int[n][];
            for (int i = 0; i < n; i++) {
                datas[i] = new int[i + 1];
                inputs = br.readLine().split(" ");
                for (int j = 0; j < i + 1; j++) {
                    datas[i][j] = Integer.parseInt(inputs[j]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                int a = datas[i][j] + datas[i + 1][j];
                int b = datas[i][j] + datas[i + 1][j + 1];

                datas[i][j] = a > b ? a : b;
            }
        }
        System.out.println(datas[0][0]);
    }
}
