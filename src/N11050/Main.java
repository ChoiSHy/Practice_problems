package N11050;
//N, K를 입력받고 이항계수 출력

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt(), K = scan.nextInt();

		System.out.println(pascal(N, K));
	}

	public static int pascal(int n, int k) {
		if (k == 0 || n - k == 0)
			return 1;
		else if (k == 1 || n - k == 1)
			return n;
		else
			return pascal(n - 1, k - 1) + pascal(n - 1, k);
	}
}
