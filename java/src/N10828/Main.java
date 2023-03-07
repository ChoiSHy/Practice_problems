package N10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stk = new Stack<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String order;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			switch (order) {
			case "push":
				stk.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (stk.empty())
					sb.append(-1).append("\n");
				else
					sb.append(stk.pop()).append("\n");
				break;
			case "top":
				if (stk.empty())
					sb.append(-1).append("\n");
				else
					sb.append(stk.peek()).append("\n");
				break;
			case "empty":
				if (stk.empty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "size":
				sb.append(stk.size()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
