package N11375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static List<Integer>[] works;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        int N = Integer.parseInt(Input[0]);
        int M = Integer.parseInt(Input[1]);

        works=new List[M];
        for(int i =0;i<M;i++){
            works[i]=new ArrayList<>();
        }

        for(int i =0;i<N;i++){
            Input=br.readLine().split(" ");
            int w = Integer.parseInt(Input[0]);
            for(int j =0;j<w;j++){
                works[Integer.parseInt(Input[j+1])-1].add(i+1);
            }
        }
        print();
    }
    static void print(){
        for (List<Integer> list : works){
            System.out.println(list.toString());
        }
    }
}
