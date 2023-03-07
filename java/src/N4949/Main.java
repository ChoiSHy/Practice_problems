package N4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		String str;
		while(!".".equals(str=br.readLine())) {
			if(comparator(str)) sb.append("yes\n");
			else sb.append("no\n");
		}
		System.out.print(sb);
	}
	
	public static boolean comparator(String str) {
		Stack<Character> stk=new Stack<>();
		char c;
		for(int i=0;i<str.length();i++) {
			c=str.charAt(i);
			if(c=='(' || c=='[') 
				stk.push(c);
			else if(c==')') {
				if(stk.empty() || stk.peek()!='(')
					return false;
				else
					stk.pop();
			}
			else if(c==']') {
				if(stk.empty() || stk.peek()!='[')
					return false;
				else
					stk.pop();
			}
		}
		if(stk.empty())
			return true;
		else
			return false;
	}
}
