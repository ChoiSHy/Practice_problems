package N3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] ring=new int[N][2];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<N;i++) {
			ring[i][1]=Integer.parseInt(st.nextToken());
			ring[i][0]=ring[0][1];
			
			int g=gcd(ring[i][0],ring[i][1]);
			
			if(i!=0)
			sb.append(ring[i][0]/g).append("/").append(ring[i][1]/g).append("\n");
		}
		System.out.println(sb);
	}
	public static int gcd(int a, int b) {
		while(b!=0) {
			int rest=a%b;
			a=b;
			b=rest;
		}
		return a;
	}

}
