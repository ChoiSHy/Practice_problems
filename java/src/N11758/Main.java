package N11758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] p = new int[3][2];

        String[] inputs;
        for (int i = 0; i < 3; i++) {
            inputs = br.readLine().split(" ");
            p[i][0] = Integer.parseInt(inputs[0]);
            p[i][1] = Integer.parseInt(inputs[1]);
        }
        int[][] d = new int[2][2];
        for (int i = 0; i < 2; i++) {
            d[i][0] = p[i + 1][0] - p[i][0];
            d[i][1] = p[i + 1][1] - p[i][1];
        }
        int res = d[0][0]*d[1][1] - d[1][0]*d[0][1];
        if(res> 0 )
            System.out.println(1);
        else if(res<0)
            System.out.println(-1);
        else
            System.out.println(0);
    }
}
