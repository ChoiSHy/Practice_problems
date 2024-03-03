package Programmers.JavaCodingTest.p3_RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("날짜를 입력하세요(MM/DD/YYYY): ");
        String date= scanner.nextLine();

        Pattern pattern = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");
        Matcher matcher = pattern.matcher(date);
        if(matcher.find()){
            System.out.printf("%s -> %s%s%s\n",date,matcher.group(3),matcher.group(1),matcher.group(2));
        }
    }
}
