package Bakjun.N11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int n, m;
        int[][] arr;

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(inputs[j - 1]);
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];

        for (int i = 0; i < m; i++) {
            int x1, x2, y1, y2;
            inputs = br.readLine().split(" ");
            x1 = Integer.parseInt(inputs[0]);
            y1 = Integer.parseInt(inputs[1]);
            x2 = Integer.parseInt(inputs[2]);
            y2 = Integer.parseInt(inputs[3]);
            sb.append(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
