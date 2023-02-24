package N9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MaIN {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		String tmp;
		int T=Integer.parseInt(br.readLine());
		HashMap<String, Integer> map=new HashMap<>();
		
		for(int i=0;i<T;i++) {
			int n=Integer.parseInt(br.readLine());
			for(int j=0;j<n;j++) {
				
				st=new StringTokenizer(br.readLine()," ");
				st.nextToken();
				tmp=st.nextToken();
				if(map.containsKey(tmp))
					map.put(tmp,map.get(tmp)+1);
				else
					map.put(tmp, 1);
			}
			int res=1;
			for(String s:map.keySet()) 
				res*=(map.get(s)+1);
			sb.append(--res).append("\n");
			
			map.clear();
		}
		System.out.println(sb);
	}
}
