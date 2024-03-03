package Bakjun.N1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		ArrayList<Integer>list=new ArrayList<>();
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < count; i++) 
			list.add(Integer.parseInt(token.nextToken()));
		
		Collections.sort(list);
		
		System.out.println(list.get(0)*list.get(list.size()-1));
	}

}
