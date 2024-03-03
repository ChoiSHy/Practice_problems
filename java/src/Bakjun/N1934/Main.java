package Bakjun.N1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
			
			if(a%b==0 || b%a==0)
				sb.append(a>b?a:b).append("\n");
			else {
				for(int j=(a>b?b:a);j>=1;j--) {
					if(a%j==0 && b%j==0) {
						sb.append((a*b)/j).append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}

}
