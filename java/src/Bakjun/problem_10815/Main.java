package Bakjun.problem_10815;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> set = new HashSet<>();

        int n = 0, m = 0;
        try {
            n = Integer.parseInt(br.readLine());
            for(String tok : br.readLine().split(" "))
                set.add(Integer.parseInt(tok));

            m = Integer.parseInt(br.readLine());
            for(String tok : br.readLine().split(" ")){
                int num = Integer.parseInt(tok);
                if(set.contains(num))
                    bw.write(1+" ");
                else
                    bw.write(0+" ");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
