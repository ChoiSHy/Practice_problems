package N1036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

class NewComp implements Comparator<Map.Entry<Character, Long>>{
    @Override
    public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
        long v1 = o1.getValue();
        long v2 = o2.getValue();
        if(v1 == v2) return o1.getKey() - o2.getKey();
        return (int)(v2-v1);
    }
}
public class Main {
    static int n, k;
    static Map<Character, Long> map;
    static String[] words;

    public static void main(String[] args) throws IOException {
        /* INPUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap();
        n = Integer.parseInt(br.readLine());
        words = new String[n];
        int longest = 0;
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer(br.readLine());
            words[i] = sb.reverse().toString();
            if (words[i].length() > longest)
                longest = words[i].length();
        }
        k = Integer.parseInt(br.readLine());
        /* change to 'Z' */
        getTopKey();
        calc(longest);

    }

    static void calc(int longest) {
        List<Integer> result = new ArrayList<>();
        int v, c = 0;

        for (int i = 0; i < longest; i++) {
            v = c;
            for (int j = 0; j < n; j++) {
                if (words[j].length() <= i) continue;
                v += Integer.parseInt(String.valueOf(words[j].charAt(i)),36);
            }
            c = v / 36;
            v = v % 36;

            result.add(v);
        }
        if(c!=0) result.add(c);
        Collections.reverse(result);
        StringBuilder sb= new StringBuilder();
        for(int i : result)
            sb.append(Integer.toString(i,36));
        System.out.println(sb.toString().toUpperCase());
    }

    static void getTopKey() {
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                char c = words[i].charAt(j);
                long d = (35 - Integer.parseInt(String.valueOf(c),36))*(long)Math.pow(10,j);
                if(d!=0){
                if (map.containsKey(c))
                    map.put(c, map.get(c) + d);
                else map.put(c, d);}
            }
        }
        List<Map.Entry<Character, Long>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(new NewComp());

        for (int i = 0; i < k; i++) {
            if(entryList.size()<=i)  break;
            char key = entryList.get(i).getKey();
            for (int j = 0; j < n; j++)
                words[j] = words[j].replace(key, 'Z');
        }
        System.out.println(entryList.toString());
        System.out.println(Arrays.toString(words));

    }
}
