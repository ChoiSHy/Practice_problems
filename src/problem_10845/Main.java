package problem_10845;

import java.io.*;

class Queue{
    int[] val;
    int size;
    int fp, bp;

    public Queue(int size){
        this.val=new int[size];
        this.size=0;
        fp = -1;
        bp = 0;
    }
    public void push(int v){
        if(size!=0 && bp==val.length)
            return;
        val[bp++]=v;
        size++;
        if(bp==val.length)
            bp=0;
    }
    public int pop(){
        if(fp>=bp || size==0)
            return -1;

        if(++fp==val.length)
            fp=0;
        size--;
        return val[fp];
    }
    public int size(){
        return size;
    }
    public int empty(){
        if(size==0)
            return 1;
        return 0;
    }
    public int front(){
        if(size==0)
            return -1;
        int idx=fp+1;
        if (idx==val.length)
            idx=0;
        return val[idx];
    }
    public int back(){
        if(size==0) return -1;
        return val[size-1];
    }
}
public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue q=null;
    public static void main(String[] args) {
        try {
            int N = Integer.parseInt(br.readLine());
            q = new Queue(N);

            for (int i = 0; i < N; i++)
                order(br.readLine().split(" "));
            bw.flush();
        }catch (IOException e){
            return;
        }

    }
    private static void order(String[] order) throws IOException {
        switch (order[0]){
            case "push":
                q.push(Integer.parseInt(order[1]));
                break;
            case "pop":
                bw.write(q.pop()+"\n");
                break;
            case "size":
                bw.write(q.size()+"\n");
                break;
            case "empty":
                bw.write(q.empty()+"\n");
                break;
            case "front":
                bw.write(q.front()+"\n");
                break;
            case "back":
                bw.write(q.back()+"\n");
                break;
        }
    }


}
