package N1036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;




public class Main {
	static Base36[] data;
	public static void main(String[] args) throws IOException {
		int k=input();
		for(Base36 b: data)
			System.out.println(b.toString());
	}
	public static int input() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		data=new Base36[n];
		for(int i=0;i<n;i++)
			data[i]=new Base36(br.readLine());
		
		return Integer.parseInt(br.readLine());
	}

}
