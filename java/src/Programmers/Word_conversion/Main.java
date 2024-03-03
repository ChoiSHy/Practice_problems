package Programmers.Word_conversion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.solution(
                "hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        );
        s.solution(
                "hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        );
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        return answer;
    }
    public int compare(String A, String B){
        int ret = 0;
        for(int i = 0 ; i<A.length();i++){
            if(A.charAt(i) == B.charAt(i)){
                ret++;
            }
        }
        return ret;
    }
}