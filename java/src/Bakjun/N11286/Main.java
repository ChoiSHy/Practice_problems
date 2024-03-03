/* 절대값 배열*/
/*
1. 배열에 정수 x (x ≠ 0)를 넣는다.
2. (x == 0) 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.*/
package Bakjun.N11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Number implements Comparable<Number> {
    int value;
    int priority;

    public Number(int value){
        this.value = value;
        if( value < 0 )
            this.priority = -value;
        else this.priority = value;
    }
    @Override
    public int compareTo(Number o) {
        if (priority == o.priority)
            return value - o.value;
        return priority-o.priority;
    }
}
public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Number> queue = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if (x != 0 ){
                queue.add(new Number(x));
            }
            else{
                if (queue.isEmpty())
                    sb.append("0\n");
                else{
                    sb.append(queue.remove().value+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
