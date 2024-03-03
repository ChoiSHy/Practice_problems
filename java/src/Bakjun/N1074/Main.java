package Bakjun.N1074;
/*
* (2^N)*(2^N)인 2차원 배열을 Z모양으로 탐색하려한다.
* 예를 들어, 2*2 배열의 경우,
* [ 0   1 ]
* [ 2   3 ]
* 순서로 탐색된다.
*
* (2^2) * (2^2)인 경우,
* [ 0   1   4   5   ]
* [ 2   3   6   7   ]
* [ 8   9   12  13  ]
* [ 10  11  14  15  ]
* 순서로 탐색된다.
*
* N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하라.
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        r = Integer.parseInt(inputs[1]);
        c = Integer.parseInt(inputs[2]);

        int res = find_answer(0, 0, N, 0);
        System.out.println(res);
    }

    public static int find_answer(int row, int col, int size, int start) {
        if (size == 0) {
            return start;
        }
        int Size = (int)Math.pow(2,size-1);
        int row_std = row + (Size );
        int col_std = col + (Size );

        if (r < row_std) {
            if (c < col_std) {
                return find_answer(row, col, size-1, start);
            } else {
                return find_answer(row, col_std, size-1,
                        start + (int) Math.pow(2, 2 * size - 2));
            }
        } else {
            if (c < col_std) {
                return find_answer(row_std, col, size-1,
                        start + (2 * (int) Math.pow(2, 2 * size - 2)));
            } else {
                return find_answer(row_std, col_std, size-1,
                        start + (3 * (int) Math.pow(2, 2 * size - 2)));
            }
        }
    }
}
