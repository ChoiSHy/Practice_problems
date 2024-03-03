package Programmers.KAKAO_2024_WINTER_INTERSHIP.P2;

import java.util.*;

public class Main {
    public static void print(Solution s, int[][] edge){
        for(int i : s.solution(edge)){
            System.out.print(i+" ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        int[][] edges1 = {
                new int[]{4, 3},
                new int[]{2, 3},
                new int[]{1, 1},
                new int[]{2, 1}
        };
        Solution s1 = new Solution();
        int[][] edges2 = {
                new int[]{4, 11},
                new int[]{1, 12},
                new int[]{8, 3},
                new int[]{12, 7},
                new int[]{4, 2},
                new int[]{7, 11},
                new int[]{4, 8},
                new int[]{9, 6},
                new int[]{10, 11},
                new int[]{6, 10},
                new int[]{3, 5},
                new int[]{11, 1},
                new int[]{5, 3},
                new int[]{11, 9},
                new int[]{3, 8}
        };
        Solution s2 = new Solution();
        int[][] edges3 = {
                new int[]{1, 4},
                new int[]{4, 3},
                new int[]{3, 2},
                new int[]{2, 1},
                new int[]{5, 3},
                new int[]{5, 6},
                new int[]{5, 9},
                new int[]{6, 7},
                new int[]{7, 8},
                new int[]{9, 10},
                new int[]{10, 11},
                new int[]{11, 12},
                new int[]{12, 13},
                new int[]{13, 11},
                new int[]{11, 9}
        };
        Solution s3 = new Solution();
        int[][] edges4 = {
                new int[]{1,1},
                new int[]{4,1},
                new int[]{4,3},
                new int[]{2,3}
        };
        Solution s4 = new Solution();

        print(s1, edges1);
        print(s2, edges2);
        print(s3, edges3);
        print(s4, edges4);
    }

}

class Solution {
    Map<Integer, Queue<Integer>> nodeMap;
    Map<Integer, Integer> countMap;

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        input(edges);
        answer[0] = find_gen_v();
        Queue<Integer> queue = nodeMap.get(answer[0]);
        while (!queue.isEmpty()) {
            int key = queue.remove();
            Set<Integer> set = new HashSet<>();
            int edge = round(key, set)-1;
            int vetx = set.size();

            if (vetx != 0) {
                if (edge == vetx) {
                    answer[1]++;
                } else if (edge + 1 == vetx) {
                    answer[2]++;
                } else if (edge == vetx + 1) {
                    answer[3]++;
                }
            }
        }
        return answer;
    }

    private int find_gen_v() {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 0){
                if(nodeMap.get(entry.getKey()).size() >1)
                    return entry.getKey();
            }
        }
        return 0;
    }

    private void input(int[][] edges) {
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        for (int[] i : edges) {
            if (!nodeMap.containsKey(i[0])) {
                nodeMap.put(i[0], new LinkedList<>());
                countMap.put(i[0], 0);
            }
            if (!nodeMap.containsKey(i[1])) {
                nodeMap.put(i[1], new LinkedList<>());
                countMap.put(i[1], 0);
            }
            nodeMap.get(i[0]).add(i[1]);
            countMap.put(i[1], countMap.get(i[1]) + 1);
        }
    }

    private int round(int v, Set<Integer> set) {
        Queue<Integer> queue = nodeMap.get(v);
        int ret = 1;
        set.add(v);

        while (!queue.isEmpty()) {
            int t = queue.remove();
            ret += round(t, set);
        }
        return ret;
    }
}
