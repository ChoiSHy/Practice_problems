package Bakjun.N15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[]visited;
	static int[]ans;
	static int N,M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		visited=new boolean[N+1];
		ans=new int[M+1];
		sb=new StringBuilder();
		
		sequence(1);
		
		System.out.println(sb);
	}
	public static void sequence(int x) {
		if(x==M+1) {
			for(int i=1;i<=M;i++)
				sb.append(ans[i]).append(" ");
			sb.append("\n");
		}
		else 
			for(int i=1;i<=N;i++) 
				if(visited[i]==false) {
					visited[i]=true;
					ans[x]=i;
					sequence(x+1);
					visited[i]=false;
				}
	}
}
