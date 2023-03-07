package N2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int hour=Integer.parseInt(st.nextToken());
		int minute=Integer.parseInt(st.nextToken());
		minute+=Integer.parseInt(br.readLine());
		
		if(minute>=60) {
			hour+=minute/60;
			minute%=60;
		}
		if(hour>23)
			hour%=24;
		
		StringBuilder sb=new StringBuilder();
		sb.append(hour).append(' ').append(minute);
		
		System.out.println(sb);
	}
}
