package N1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class calcCount {
	int distance;

	public calcCount(int distance) {
		this.distance = distance;
	}

	public int calculation() {
		int max=(int)Math.sqrt(distance);
		
		if(max==Math.sqrt(distance))
			return max*2-1;
		else if(distance <=max*max+max)
			return max*2;
		else
			return max*2+1;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		
		calcCount[] Case=new calcCount[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			Case[i] = new calcCount(to - from);
		}
		
		reader.close();
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++)
			sb.append(Case[i].calculation()).append("\n");
		System.out.println(sb);
	}
}
