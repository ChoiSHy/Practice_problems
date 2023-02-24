package N18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(buf.readLine());
		
		int[][] arr=new int [2][N];
		
		StringTokenizer token=new StringTokenizer(buf.readLine()," ");
		
		for(int i=0;i<N;i++)
			arr[0][i]=arr[1][i]=Integer.parseInt(token.nextToken());
		
		Arrays.sort(arr[1]);
		
		HashMap<Integer, Integer> map=new HashMap<>();
		
		int j=0;
		for(int i=0;i<N;i++) 
			if(!map.containsKey(arr[1][i]))
				map.put(arr[1][i], j++);
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) 
			sb.append(map.get(arr[0][i])).append(" ");
		
		System.out.println(sb);
	}
}