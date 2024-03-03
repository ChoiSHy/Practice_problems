package Programmers.JavaCodingTest.p2_StringTest.p1;
//trim
//concat
//charAt
//substring

//StringBuffer
    // append()
    // capacity()
    // reverse()
    // delete()
    // insert()
    // setLength()


import java.util.Scanner;

public class StringTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean answer = true;
        String str= scanner.nextLine().trim();
        for(int i = 0; i<str.length()-1;i++){
            char c = str.charAt(i);
            if(c == ' ') continue;

            String sub = str.substring(i+1);
            if(sub.contains(String.valueOf(c)))
                answer = false;
        }
        System.out.println(answer);

    }
}
