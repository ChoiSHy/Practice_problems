package Programmers.Chuseok_traffic;


class Solution {
    int[][] times;
    public int solution(String[] lines) {
        int answer = 0;
        times = new int[lines.length][3];

        data_split(lines);

        for (int i = 0; i < lines.length; i++) {
            for (int j = i; j < lines.length; j++) {
                if(i==j) continue;

                if(times[i][1] + 1000 > times[j][0] ){
                    times[i][2]++;}
            }
            if (times[i][2]+1 > answer)
                answer=times[i][2]+1;
        }

        return answer;
    }
    void data_split(String[] lines){
        for (int i =0;i<lines.length;i++){
            String[] tokens = lines[i].split("-|:|\s|s");

            int hour = Integer.parseInt(tokens[3])*1000*60*60;
            int min = Integer.parseInt(tokens[4])*1000*60;
            int sec = (int)(1000 * Double.parseDouble(tokens[5]));
            int intSec = (int)(1000 * Double.parseDouble(tokens[6]));

            times[i][1] = hour+min+sec;
            times[i][0] = times[i][1] - intSec + 1;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"});
        s.solution(new String[]{
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"});
        s.solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        });
    }
}
