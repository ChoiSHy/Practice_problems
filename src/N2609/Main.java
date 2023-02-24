package N2609;
// 최대공약수와 최소공배수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
		
		for(int i=(a>b?b:a);i>=1;i--) {
			if(a%i==0 && b%i==0) {
				sb.append(i).append("\n");
				break;
			}	
		}
		for(int i=(a>b?a:b);i<=a*b;i++) {
			if(i%a==0 && i%b==0) {
				sb.append(i).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
