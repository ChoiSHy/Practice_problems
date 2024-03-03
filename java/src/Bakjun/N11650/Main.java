package Bakjun.N11650;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int[][] arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=scan.nextInt();	//xpos
			arr[i][1]=scan.nextInt();	//ypos
		}
		
		Arrays.sort(arr, (a,b) ->{
			if(a[0]==b[0])
				return a[1]-b[1];
			else
				return a[0]-b[0];
		});
		
		StringBuilder sb=new StringBuilder();
		for(int[] p : arr) 
			sb.append(p[0]).append(" ").append(p[1]).append("\n");
		System.out.println(sb);
	}
}
