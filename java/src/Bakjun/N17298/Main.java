package Bakjun.N17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static Stack<Integer> stk = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		NGE();

		System.out.println(sb);
	}

	public static void NGE() {
		for (int i = 0; i < N; i++) {
			if (arr[i] < arr[i + 1]) {
				while(!stk.empty())
					sb.append(arr[i + 1]).append(" ");
			}
			else
				stk.push(i);
		}
	}
}
