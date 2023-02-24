package N1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int[] arr=new int[4];
		
		for(int i=0;i<4;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		arr[2]-=arr[0];
		arr[3]-=arr[1];
		
		Arrays.sort(arr);
		
		System.out.println(arr[0]);	
	}
}