package Programmers.JavaCodingTest.p2_StringTest.p2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String p = scanner.nextLine();
        String q = scanner.nextLine();
        boolean answer = false;
        if(p.length() == q.length()){
            Set<Character> set = new HashSet<>();
            for(char c : p.toCharArray())
                set.add(c);
            for(char c : q.toCharArray())
                set.add(c);

            if(set.size()-1 == p.length())
                answer = true;

        }else{
            Set<Character> ps = new HashSet<>();
            Set<Character> qs  = new HashSet<>();
            if(p.length() - q.length() == 1){
                for(char c : p.toCharArray())
                    ps.add(c);
                for(char c : q.toCharArray())
                    qs.add(c);

                if(ps.containsAll(qs))
                    answer = true;
            }
            else if(p.length() - q.length() == -1){
                for(char c : p.toCharArray())
                    ps.add(c);
                for(char c : q.toCharArray())
                    qs.add(c);
                if(qs.containsAll(ps))
                    answer = true;
            }
        }
        System.out.println(answer);
    }
}
