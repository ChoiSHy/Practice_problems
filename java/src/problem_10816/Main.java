package problem_10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map = new HashMap<>();

        try{
            int n = Integer.parseInt(br.readLine());
            for(String tok : br.readLine().split(" ")){
                int num = Integer.parseInt(tok);

                if(map.containsKey(num))
                    map.put(num, map.get(num)+1);
                else
                    map.put(num, 1);
            }
            int m = Integer.parseInt(br.readLine());
            for(String tok : br.readLine().split(" ")){
                int num = Integer.parseInt(tok);
                if(map.containsKey(num))
                    bw.write(map.get(num)+" ");
                else
                    bw.write(0+" ");
            }
            bw.flush();
            bw.close();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
