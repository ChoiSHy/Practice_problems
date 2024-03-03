package Programmers.PCCP.Analog_Clock;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(0, 5, 30, 0, 7, 0);
        s.solution(12, 0, 0, 12, 0, 30);
        s.solution(0, 6, 1, 0, 6, 6);
        s.solution(11, 59, 30, 12, 0, 0);
        s.solution(11, 58, 59, 11, 59, 0);
        s.solution(1, 5, 5, 1, 5, 6);
        s.solution(0, 0, 0, 23, 59, 59);
    }
}

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        //System.out.println(String.format("%02d:%02d:%02d ~ %02d:%02d:%02d", h1, m1, s1, h2, m2, s2));
        int answer = 0;
        double start = (h1 * 3600) + (m1 * 60) + s1;
        double end = (h2 * 3600) + (m2 * 60) + s2;

        if (start == 0 || start == 43200)
            answer++;
        double h ;
        double m ;
        double s ;

        double next_h ;
        double next_m ;
        double next_s ;
        while (start < end) {
            h = (start/120) % 360;
            m = (start/10) % 360;
            s = (start*6) % 360;

            next_h = ((start+1) / 120) % 360;
            next_m = ((start+1) / 10) % 360;
            next_s = ( (start+1) * 6) % 360;

            if(next_h ==0)
                next_h=360;
            if(next_m==0)
                next_m=360;
            if(next_s==0)
                next_s=360;

            if(next_h == next_m && next_m == next_s){
                answer++;
                start++;
                continue;
            }
            if(h > s && next_h <= next_s) answer++;
            if(m > s && next_m <= next_s) answer++;
            start++;
        }

        //System.out.println(String.format("answer = %d\n", answer));
        return answer;
    }

}
