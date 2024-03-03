package Bakjun.N5086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n1,n2;
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n1=Integer.parseInt(st.nextToken());
			n2=Integer.parseInt(st.nextToken());
			
			if(n1==0 && n2==0)
				break;
			
			if(n2%n1==0) 
				sb.append("factor\n");
			else if(n1%n2==0)
				sb.append("multiple\n");
			else
				sb.append("neither\n");
		}
		System.out.println(sb);
	}

}
