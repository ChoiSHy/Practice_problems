package Programmers.Word_conversion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.solution(
                "hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        );
        s.solution(
                "hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}
        );
        s.solution(
                "goal", "cook", new String[]{"coal", "cool", "cook", "gral", "grpl"}
        );
    }
}

class Solution {
    Map<String, Set<String>> edges;
    Set<String> visit;

    public int solution(String begin, String target, String[] words) {
        edges = new HashMap<>();
        visit = new HashSet<>();
        edges.put(begin, new HashSet<>());
        for (String word : words) {
            edges.put(word, new HashSet<>());
        }

        List<String> keys = new ArrayList<>(edges.keySet());
        for (int i = 0; i < edges.size(); i++) {
            String key = keys.get(i);
            for (int j = i + 1; j < edges.size(); j++) {
                String word = keys.get(j);
                if (compare(key, word)) {
                    edges.get(key).add(word);
                    edges.get(word).add(key);
                }
            }
        }

        System.out.println(edges);

        int answer = dfs(begin, target, 0);
        System.out.println("Result: " + answer);
        return answer;
    }

    int dfs(String cur, String target, int lvl) {
        Set<String> vtxs = edges.get(cur);
        visit.add(cur);
        //System.out.println("visit: " + cur+"\tlevel: "+lvl);
        int ret = 0;
        for (String key : vtxs) {
            /* 방문한 정점 */
            if (visit.contains(key))
                continue;
            /* 타깃 찾음 */
            if (key.equals(target))
                ret = lvl + 1;
            /* 그 외 */
            else {
                int res = dfs(key, target, lvl + 1);
                if ((res != 0 && res < ret)|| ret == 0)
                    ret = res;
            }
        }
        visit.remove(cur);
        return ret;

    }

    boolean compare(String A, String B) {
        int ret = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                ret++;
            if (ret > 1) return false;
        }
        return true;
    }
}