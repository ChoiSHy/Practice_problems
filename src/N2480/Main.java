package N2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] arr=new int[6];
		
		for(int i=0;i<3;i++)
			arr[Integer.parseInt(st.nextToken())-1]++;
		int big=0;
		int idx=0;
		for(int i=0;i<6;i++) {
			if(arr[i]>=big) {
				big=arr[i];
				idx=i;
			}
		}
		int result=0;
		
		if(big==3) {
			result=10000+1000*(idx+1);
		}
		else if(big==2) {
			result=1000+100*(idx+1);
		}
		else {
			result=100*(idx+1);
		}
		
		System.out.println(result);
	}

}
