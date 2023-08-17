package N1322;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long k = scanner.nextLong();
        String xbit = Long.toBinaryString(x);
        String kbit = Long.toBinaryString(k);
        int xlen = xbit.length();
        int klen = kbit.length();

        StringBuilder sb= new StringBuilder();
        for (int i = xlen-1; i >= 0; i--) {
            if(klen >0 && xbit.charAt(i) == '0' ){
                sb.append(kbit.charAt(--klen));
            }
            else{
                sb.append(0);
            }
        }
        while(klen>0)
            sb.append(kbit.charAt(--klen));
        System.out.println(Long.valueOf(sb.reverse().toString(),2));
    }

}
