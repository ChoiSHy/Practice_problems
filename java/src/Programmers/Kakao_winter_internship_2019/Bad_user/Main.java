package Programmers.Kakao_winter_internship_2019.Bad_user;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Set<Set<String>> check;
    public int solution(String[] user_id, String[] banned_id) {
        List<String> b_ids = Arrays.stream(banned_id)
                .map(e -> e.replace("*", "."))
                .collect(Collectors.toList());
        Map<String, Set<String>> match_ids = new HashMap<>();
        check = new HashSet<>();
        for (String b : b_ids) {
            if (!match_ids.containsKey(b))
                match_ids.put(b, new HashSet<>());

            for (String id : user_id) {
                if (id.matches(b)) {
                    match_ids.get(b).add(id);
                }
            }
        }
        //Arrays.stream(banned_id).forEach(e-> System.out.print(e+"\t"));
        //System.out.println();
        int answer = solve(b_ids, match_ids, new HashSet<>(), 0);
        //System.out.println("answer: "+answer);
        return answer;
    }

    public int solve(List<String> banned_ids, Map<String, Set<String>> match, Set<String> result, int idx) {
        if(idx == banned_ids.size()){
            int cnt = (int)result.stream().distinct().count();
            if(cnt != banned_ids.size() || check.contains(result))
                return 0;
            check.add(new HashSet<>(result));
            //System.out.println(result);
            return 1;
        }
        if(idx > result.size()) return 0;
        String b_id = banned_ids.get(idx);
        Set<String> users = match.get(b_id);
        int ret = 0;
        for(String user : users){
            boolean f = result.add(user);
            //System.out.println(String.format("\t[%d]%s\t%s --> %s",idx,b_id, user, result.toString()));
            ret+= solve(banned_ids, match, result, idx+1);
            if(f) {
                result.remove(user);
                //System.out.println(String.format("\t[%d]%s\t%s <-- %s", idx,b_id, user, result.toString()));
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
        s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
        s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc", "fredi"}, new String[]{"fr*d*", "*rodo", "******", "*****"});
    }
}
