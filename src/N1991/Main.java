package N1991;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;	
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr=new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int head=st.nextToken().charAt(0)-'A';
			arr[head][0]=st.nextToken().charAt(0)-'A';
			arr[head][1]=st.nextToken().charAt(0)-'A';
		}
		
		preorder(0);
		sb.append('\n');
		inorder(0);
		sb.append('\n');
		postorder(0);
		sb.append('\n');
		System.out.println(sb);
	}

	public static void preorder(int p) {
		if(p==-19)	return;
		sb.append((char)(p+'A'));
		preorder(arr[p][0]);
		preorder(arr[p][1]);
	}
	public static void inorder(int p) {
		if(p==-19) return;
		inorder(arr[p][0]);
		sb.append((char)(p+'A'));
		inorder(arr[p][1]);
	}
	public static void postorder(int p) {
		if(p==-19) return;
		postorder(arr[p][0]);
		postorder(arr[p][1]);
		sb.append((char)(p+'A'));
	}


}

