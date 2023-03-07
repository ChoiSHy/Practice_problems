package N2751;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		int size=scan.nextInt();
		
		ArrayList<Integer> arr=new ArrayList();
		for(int i=0;i<size;i++)
			arr.add(scan.nextInt());
		
		Collections.sort(arr);
		
		StringBuilder sb=new StringBuilder();
		
		for(Integer i:arr) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
		
	}
}
