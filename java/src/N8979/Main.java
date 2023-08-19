package N8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Nation implements Comparable<Nation>{
    int gold;
    int silver;
    int bronze;

    public Nation(int g, int s, int b){
        this.gold =g;
        this.silver=s;
        this.bronze=b;
    }

    @Override
    public int compareTo(Nation o) {
        if(this.gold == o.gold){
            if(this.silver == o.silver)
                return this.bronze - o.bronze;
            else
                return this.silver - o.silver;
        }
        return this.gold - o.gold;
    }
}
class MyComp implements Comparator<Map.Entry<Integer, Nation>> {
    int k;
    public MyComp(int k){
        this.k=k;
    }
    @Override
    public int compare(Map.Entry<Integer, Nation> o1, Map.Entry<Integer, Nation> o2) {
        int res = o1.getValue().compareTo(o2.getValue());
        if (res == 0){
            if(o1.getKey() == k) return -1;
            else if (o2.getKey()==k) return 1;
            else return 0;
        }
        return -res;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        Map<Integer, Nation> nations = new HashMap<>();
        MyComp comp = new MyComp(k);

        for(int i=0;i<n;i++){
            inputs = br.readLine().split(" ");
            int g = Integer.parseInt(inputs[1]);
            int s = Integer.parseInt(inputs[2]);
            int b = Integer.parseInt(inputs[3]);
            nations.put(Integer.parseInt(inputs[0]), new Nation(g,s,b));
        }
        List<Map.Entry<Integer, Nation>> sortedList = new ArrayList<>(nations.entrySet());
        sortedList.sort(comp);
        int i=1;
        for(Map.Entry<Integer,Nation> entry : sortedList){
            int key = entry.getKey();
            if(key == k) break;
            i++;
        }

        System.out.println(i);

    }
}
