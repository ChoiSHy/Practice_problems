package Programmers.JavaCodingTest.p3_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);

        while(m.find()){
            System.out.println(m.group());
        }


    }
}
