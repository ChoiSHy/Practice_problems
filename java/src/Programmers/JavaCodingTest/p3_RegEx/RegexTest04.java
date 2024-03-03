package Programmers.JavaCodingTest.p3_RegEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
        Pattern pattern = Pattern.compile("(\\d+)([A-Z])([#*]?)");
        Matcher matcher = pattern.matcher(dartResult);

        List<Integer> point = new ArrayList<>();
        while(matcher.find()){
            int d = Integer.valueOf(matcher.group(1));
            String b = matcher.group(2);
            String o = matcher.group(3);

            switch (b){
                case "S":
                    break;
                case "D":
                    d *= d;
                    break;
                case "T":
                    d *= (d*d);
                    break;
            }
            switch (o){
                case "#":
                    d *=-1;
                    break;
                case "*":
                    d*=2;
                    if(point.size()>0){
                        int idx= point.size()-1;
                        point.set(idx,point.get(idx)*2);
                    }
                    break;
            }
            point.add(d);
        }
        System.out.println(point);

        int sum = 0;
        for(int d : point){
            sum += d;
        }
        return sum;
    }
}
public class RegexTest04 {
    public static void main(String[] args) {
        Solution s= new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println(s.solution(scanner.nextLine()));
    }
}
