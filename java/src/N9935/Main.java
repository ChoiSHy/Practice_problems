package N9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Stack{
    int top;
    int len;
    char[] data;
    public Stack(int len){
        this.len=len;
        this.top = -1;
        this.data = new char[len];
    }
    public void push(char c){
        if(top >= len-1)
            return;
        data[++top] = c;
    }
    public char pop(){
        if(top == -1)
            return '\0';
        return data[top--];
    }
    public String getRange(int from){
        if(isEmpty())
            return "";
        StringBuilder sb =new StringBuilder();
        int i = (top - from) >=0 ? top-from:0;
        for(;i<top+1;i++){
            sb.append(data[i]);
        }
        return sb.toString();
    }
    public boolean isEmpty(){
        if(top<0)
            return true;
        return false;
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<top+1;i++)
            sb.append(data[i]);
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string=null;
        String explode=null;
        try {
             string = br.readLine().toCharArray();
             explode = br.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        Stack stack = new Stack(string.length);
        int lenE=explode.length();

        for(int i =0 ;i<string.length;i++){
            stack.push(string[i]);
            if(stack.getRange(lenE-1).compareTo(explode)==0){
                for(int j =0;j<lenE;j++)
                    stack.pop();
            }
        }
        if(stack.isEmpty())
            System.out.println("FRULA");
        else
            System.out.println(stack.toString());



    }
}