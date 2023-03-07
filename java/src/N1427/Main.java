package N1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<str.length();i++) 
			list.add(Character.getNumericValue(str.charAt(i)));
		
		Collections.sort(list,Collections.reverseOrder());
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<list.size();i++)
			sb.append(list.get(i));
		
		System.out.println(sb);
	}
}
