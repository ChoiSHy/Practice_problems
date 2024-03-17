package Programmers.Kakao_winter_internship_2019.Bad_user;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        List<String> b_ids = Arrays.stream(banned_id)
                .map(e -> e.replace("*", "."))
                .collect(Collectors.toList());
        Map<String, Set<String>> match_ids = new HashMap<>();
        for (String b : b_ids) {
            if (!match_ids.containsKey(b))
                match_ids.put(b, new HashSet<>());

            for (String id : user_id) {
                if (id.matches(b)) {
                    match_ids.get(b).add(id);
                }
            }
        }
        match_ids.entrySet().stream().forEach(e-> System.out.println(e.getKey()+"\t: "+e.getValue()));
        System.out.println();
        int answer = solve(b_ids, match_ids, new HashSet<>(), 0);
        System.out.println("answer: "+answer);
        return answer;
    }

    public int solve(List<String> banned_ids, Map<String, Set<String>> match, Set<String> result, int idx) {
        if(idx == banned_ids.size()){
            if(result.size() != banned_ids.size())
                return 0;
            return 1;
        }
        String b_id = banned_ids.get(idx);
        Set<String> users = match.get(b_id);
        int ret = 0;
        for(String user : users){
            result.add(user);
            System.out.println(String.format("\t%s[%d]\t%s -> %s",b_id,idx, user, result.toString()));
            int res = solve(banned_ids, match, result, idx+1);
            if(res != 0){
                result.remove(user);
                ret += res;
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        //s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        //s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
        s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
        //s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc", "fredi"}, new String[]{"fr*d*", "*rodo", "******", "*****"});
    }
}
