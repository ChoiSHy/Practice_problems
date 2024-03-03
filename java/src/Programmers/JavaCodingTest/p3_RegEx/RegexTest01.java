package Programmers.JavaCodingTest.p3_RegEx;




import java.util.Scanner;
/*
// [0-9]{5} : 숫자 5개
// Matcher
    // matches()
    // find()
    // group()
    // start()
    // end()
    // replaceAll()

// ^ string start ..... [^abc] : abc가 아닌 문자
// $ string end
// ? 0 or 1
// \s blank
// \S not blank
// \w alphabet or digit
// \W not \w
// \d digit
// \D not digit*/
public class RegexTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true){
            System.out.print("휴대전화 번호를 입력하세요 (종료는 q): ");
            if((input = scanner.nextLine()).equals("q"))
                break;
            if(input.matches("^010-\\d{4}-\\d{4}$"))
                System.out.println("정확한 전화번호 양식입니다.");
            else System.out.println("잘못된 전화번호 양식입니다.");

        }
    }
}
