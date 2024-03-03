package Bakjun.N11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dp[][];
	public static final int div = 10007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		dp=new int[n+1][k+1];
		
		System.out.println(combination(n,k));
		
	}
	static int combination(int n, int k) {
		if(dp[n][k]>0)
			return dp[n][k];
		if(k==0 || k==n)
			return dp[n][k]=1;
		return dp[n][k]=(combination(n-1,k-1)+combination(n-1,k))%div;
	}
}