package Programmers.Farthest_node;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
}

class Solution {
    Map<Integer, Integer> dept;
    List<Integer>[] edges;

    public int solution(int n, int[][] edge) {
        set(n, edge);
        bfs();
        int max = dept.values().stream().max((o1, o2) -> o1-o2).get();
        System.out.println("max : "+max);
        int answer = (int)dept.values().stream().filter(o->o==max).count();
        System.out.println("answer : "+answer);
        return answer;
    }

    void set(int n, int[][] edge) {
        edges = new List[n + 1];
        dept = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        //Arrays.stream(edges).forEach(e-> System.out.println(e));
    }

    void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        dept.put(1, 0);
        int level = 1;
        while(!queue.isEmpty()){
            int qSize = queue.size();
            for(int i =0;i<qSize;i++){
                int vtx = queue.remove();
                for(int v : edges[vtx]){
                    if(!dept.containsKey(v)){
                        dept.put(v, level);
                        queue.add(v);
                    }
                }
            }
            level++;
        }
    }

}