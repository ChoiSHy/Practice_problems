package N3053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int R=Integer.parseInt(reader.readLine());
		
		System.out.println(R*R*Math.PI);
		System.out.println(R*R*2);
	}
}
