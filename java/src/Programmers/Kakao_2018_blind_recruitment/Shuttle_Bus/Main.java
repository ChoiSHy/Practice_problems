package Programmers.Kakao_2018_blind_recruitment.Shuttle_Bus;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(
                1, 1, 5,
                new String[]{"08:00", "08:01", "08:02", "08:03"});
        s.solution(
                2, 10, 2,
                new String[]{"09:10", "09:09", "08:00"}
        );
        s.solution(
                2, 1, 2,
                new String[]{"09:00", "09:00", "09:00", "09:00"}
        );
        s.solution(
                1, 1, 5,
                new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}
        );
        s.solution(
                1, 1, 1,
                new String[]{"23:59"});
        s.solution(
                10, 60, 45,
                new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}
        );
    }
}

class Bus {
    int size;
    int[] crews;

    public Bus(int m) {
        size = 0;
        crews = new int[m];
    }

    public boolean add(int time) {
        if (size >= crews.length) return false;

        crews[size++] = time;
        return true;
    }
}

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> crews = timeToInt(timetable);
        return intToTime(solve(n,t,m,crews));
    }

    public int solve(int n, int t, int m, Queue<Integer> crews) {
        int i = 0;
        int ret = 9 * 60;
        int time = 9 * 60;
        Map<Integer, Bus> bus = new HashMap<>();

        while (!crews.isEmpty() && i < n) {
            if (!bus.containsKey(time))
                bus.put(time, new Bus(m));

            int crew = crews.remove();
            if((time < crew && i < n) || !bus.get(time).add(crew)){
                time += t;
                crews.add(crew);
                i++;
            }
        }
        List<Map.Entry<Integer, Bus>> entries = new ArrayList<>(bus.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        Map.Entry<Integer, Bus> lastBus = entries.get(entries.size()-1);

        if(!lastBus.getValue().add(lastBus.getKey())){
            Integer[] lastCrews = Arrays.stream(lastBus.getValue().crews)
                    .boxed()
                    .toArray(Integer[]::new);
            Arrays.sort(lastCrews, Collections.reverseOrder());
            ret = lastCrews[0]-1;
        }
        else{
            ret = lastBus.getKey();
        }
        System.out.println("answer: "+intToTime(ret));
        return ret;
    }

    public Queue<Integer> timeToInt(String[] timetable) {
        Queue<Integer> ret = new PriorityQueue<>();
        for (int i = 0; i < timetable.length; i++) {
            String[] input = timetable[i].split(":");
            ret.add(Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]));
        }
        return ret;
    }
    public String intToTime(int time){
        int h = time / 60;
        int m = time % 60;
        return String.format("%02d:%02d", h, m);
    }
}
