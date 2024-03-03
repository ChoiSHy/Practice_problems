package Bakjun.N1181;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		
		int N=scan.nextInt();
		
		String[] words=new String[N];
		
		scan.nextLine();
		for(int i=0;i<N;i++) 
			words[i]=scan.nextLine();
		
		Arrays.sort(words, new Comparator<String>(){
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) 
					return o1.compareTo(o2);		
				else
					return o1.length()-o2.length();
			}
		});
		
		StringBuilder sb=new StringBuilder();
		sb.append(words[0]).append("\n");
		
		for(int i=1;i<N;i++) {
			if(words[i-1].compareTo(words[i])!=0)
				sb.append(words[i]).append("\n");
			}
		System.out.println(sb);
	}
}
