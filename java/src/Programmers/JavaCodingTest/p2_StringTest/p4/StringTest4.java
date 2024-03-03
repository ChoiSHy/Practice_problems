package Programmers.JavaCodingTest.p2_StringTest.p4;

public class StringTest4 {
    public static void main(String[] args) {

        String a = (Integer.toString(45, 3));
        StringBuilder sb = new StringBuilder(a);
        sb.reverse();

        System.out.println(Integer.parseInt(sb.toString(), 3));

    }
}
