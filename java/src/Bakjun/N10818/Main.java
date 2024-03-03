package Bakjun.N10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for(String i : inputs){
                list.add(Integer.parseInt(i));
            }
            Collections.sort(list);
            System.out.println(list.get(0) + " "+list.get(list.size()-1));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
