package N1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int d;
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        int[] heads;
        try {
            n = Integer.parseInt(br.readLine());
            heads = new int[n];
            for (int i = 0; i < n; i++)
                nodes.put(i, new ArrayList<>());
            String[] inputs = br.readLine().split(" ");
            d = Integer.parseInt(br.readLine());
            int i = -1;
            for (String s : inputs) {
                i++;
                int p = Integer.parseInt(s);
                if (p == -1)
                    continue;
                List<Integer> list = nodes.get(p);
                list.add(i);
                nodes.put(p, list);
                heads[i]=p;
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        delete(d, nodes, heads);
        countLeaf(nodes);
    }
    static void delete(int d, Map<Integer, List<Integer>> nodes, int[] heads){
        Queue<Integer> delQ= new LinkedList<>();
        List<Integer> list = nodes.get(d);
        for(int i: list)
            delQ.add(i);
        nodes.remove(d);
        list = nodes.get(heads[d]);
        if(list!=null)
            list.remove((Object)d);
        while(!delQ.isEmpty()){
            int delNode = delQ.poll();
            list = nodes.get(delNode);
            for(int i : list)
                delQ.add(i);
            nodes.remove(delNode);
            list = nodes.get(heads[delNode]);
            if(list!=null)
                list.remove((Object)delNode);
        }
    }
    static void countLeaf(Map<Integer, List<Integer>> nodes){
        int cnt = 0;
        for(List<Integer> list :nodes.values())
            if(list.isEmpty())
                cnt++;
        System.out.println(cnt);
    }
}
