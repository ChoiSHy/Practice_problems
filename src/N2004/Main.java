package N2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int two=count2(n)-count2(m)-count2(n-m);
		int five=count5(n)-count5(m)-count5(n-m);
		
		System.out.println(two<five?two:five);
	}
	static int count2(int n) {
		int count=0;
		while(n>=2) {
			count+=n/2;
			n/=2;
		}
		return count;
	}
	static int count5(int n) {
		int count=0;
		while(n>=5) {
			count+=n/5;
			n/=5;
		}
		return count;
	}

}
