package Programmers.Kakao_2018_blind_recruitment.Auto_completion;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Node {
    int level;
    char key;
    String word;
    Node parent;
    Map<Character, Node> children;

    public Node() {
        this.children = new HashMap<>();
    }

    public Node(char c, int level, Node parent) {
        this.level = level;
        this.key = c;
        this.parent = parent;
        children = new HashMap<>();
    }

    public Node add(String word) {
        Node cur = this;
        int idx = 0;

        while (idx < word.length()){
            char c = word.charAt(idx);
            if (!cur.children.containsKey(c))
                cur.children.put(c, new Node(c, idx, cur));

            Node next = cur.children.get(c);

            if(idx == word.length() -1)
                next.word = word;

            cur = next;
            idx++;
        }
        return cur;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, 0);

        return sb.toString();

    }

    private void toString(StringBuilder sb, int lvl) {
        for (int i = 0; i < lvl; i++)
            sb.append("\t");
        sb.append("└");
        for (int i = 0; i < lvl; i++)
            sb.append("-");
        sb.append("key: ").append(key);
        if (word != null)
            sb.append("\tword: ").append(word);
        sb.append("\n");
        for (Node next : children.values()) {
            next.toString(sb, lvl + 1);
        }
    }
}

class Solution {
    public int solution(String[] words) {
        Node dict = new Node();
        Map<String, Node> map = new HashMap<>();
        for (String word : words) {
            Node node = dict.add(word);
            map.put(word, node);
        }
        for (String word : words) {
            Node cur = map.get(word);
            Node par = cur.parent;
            while (par!=null && par.children.size() == 1 && par.word == null) {
                if(cur.level == word.length()-1 && cur.children.size()!= 0)
                    break;
                if(par.parent == null) break;
                cur.word = null;
                par.word = word;
                cur = par;
                par = cur.parent;
            }
            map.put(word, cur);

        }
        System.out.println(dict);

        int answer = 0;
        for(Node cur : map.values()){
            answer += cur.level+1;
        }
        System.out.println("answer: "+ answer);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.solution(new String[]{"go", "gone", "guild"});
        s.solution(new String[]{"abc","def","ghi","jklm"});
        s.solution(new String[]{"word","war","warrior","world"});
        s.solution(new String[]{"w","a","b"});

    }
}
