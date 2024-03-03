package Bakjun.N1003;

import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int stop;
	static StringBuilder sb;
	public static void main(String[] args) {
		int t;
		int n;
		arr=new int[40][2];
		Scanner scan=new Scanner(System.in);
		
		t = scan.nextInt();
		sb=new StringBuilder();
		
		for(int i=0;i<t;i++) {			
			n=scan.nextInt();
			fibonacci(n);	
		}
		System.out.println(sb);

	}
	public static void fibonacci(int n) {
		stop=1;
		
		arr[0][0]=1;arr[0][1]=0;
		arr[1][0]=0;arr[1][1]=1;
		
		if(stop>n) {
			sb.append(arr[n][0]+" "+arr[n][1]+"\n");
			return;
		}
		for(int i=2;i<=n;i++) {
			arr[i][0]=arr[i-1][0]+arr[i-2][0];
			arr[i][1]=arr[i-1][1]+arr[i-2][1];
			stop++;
		}
		sb.append(arr[n][0]+" "+arr[n][1]+"\n");
	}
}
