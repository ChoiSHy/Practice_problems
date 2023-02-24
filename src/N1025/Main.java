package N1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

//1025

class Row{
	int idx;
	ArrayList<Character> row;
	
	public Row() {
		idx=0;
	}
	public void put(HashSet<Character> hsm) {
		row=new ArrayList<>(hsm);
	}
	public char get() {
		char c=row.get(idx++);
		idx/=row.size();
		return c;
	}
}
class Matrix{
	int n;
	Row[] R;
	
	public Matrix(int n) {
		this.n=n;
		R=new Row[n];
	}
	public int makeInt() {
		int max=0;
		
		
		
		return max;
	}
	public int makeInt_d(int d) {
		String str=null;
		int max;		
		
		for(int i=0;i<n;i+=d) {
			str+=R[i].get();
		}
		max=Integer.parseInt(str);
		
		
		
		return max;
	}
}
public class Main {
	static int n;
	static int m;
	static int max;	
	
	static Matrix matrix;
	
	public static void main(String[] args) throws IOException{
		max=0;
		input();
		print();
		
	}
	static void input() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashSet<Character> hsmap=new HashSet<>();
		String[] nm=new String[2];
		/* n,m input */
		nm[1]=br.readLine();
		nm=nm[1].split(" ");
		
		n=Integer.parseInt(nm[0]);
		m=Integer.parseInt(nm[1]);
		matrix=new Matrix(n);
				
		/* matrix input */
		for(int i=0;i<n;i++) {
			hsmap.clear();
			matrix.R[i]=new Row();
			
			nm[0]=br.readLine();
			
			for(int j=0;j<m;j++) 
				hsmap.add(nm[0].charAt(j));
			
			matrix.R[i].put(hsmap);
		}
	}
	static void print() {
		/* print matrix */
		for(int i=0;i<n;i++) {
			for(char e:matrix.R[i].row) {
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}
