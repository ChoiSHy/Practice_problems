package Programmers.Kakao_2021_blind_recruitment.Minimizing_decline_in_sales;

import java.util.*;
/* 해결 못함 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();/*
        s.solution(
                new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17},
                new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}}
        );*/
        s.solution(
                new int[]{5, 6, 5, 3, 4},
                new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}
        );/*
        s.solution(
                new int[]{5, 6, 5, 1, 4},
                new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}
        );*/
        /*
        s.solution(
                new int[]{10, 10, 1, 1},
                new int[][]{{3, 2}, {4, 3}, {1, 4}}
        );*/

    }
}
class Solution {
    Map<Integer, List<Integer>> teams;
    Set<Integer> completes;
    int sum;
    int[] sales;

    public int solution(int[] sales, int[][] links) {
        set(sales, links);
        for(List<Integer> team : teams.values())
            Collections.sort(team, (x,y) -> {
                return sales[x-1] - sales[y-1];
            });
        print();
        System.out.println();

        solve(1);


        int answer = 0;
        return answer;
    }
    private void solve(int team){
        for(int i : teams.get(team)){
            if(i==team) continue;
            if(teams.containsKey(i)){
                int common = getCommon(team, i);
                int minA=0;
                int minB=0;
                for(int j : teams.get(team)){
                    if(j != common){
                        minA=j;
                        break;
                    }
                }
                for(int j : teams.get(i)){
                    if(j != common){
                        minB=j;
                        break;
                    }
                }

                if(sales[minA-1] + sales[minB] < sales[common]){
                    sum += sales[minA-1] + sales[minB];
                }
                else{
                    sum += sales[common];
                }
                completes.add(team);
                completes.add(i);
                break;
            }
        }
    }
    private int getCommon(int a, int b){
        Set<Integer> n = new HashSet<>(teams.get(a));
        n.retainAll(teams.get(b));
        return n.iterator().next();
    }

    private void set(int[] sales, int[][] links){
        this.sum=0;
        this.sales = sales;
        this.teams = new HashMap<>();
        this.completes = new HashSet<>();

        for(int[] link : links){
            int team = link[0];
            int member = link[1];

            if(!teams.containsKey(team)){
                List<Integer> newTeam = new ArrayList<>();
                newTeam.add(team);
                teams.put(team, newTeam);
            }
            teams.get(team).add(member);
        }
    }
    private void print(){
        for(Map.Entry<Integer, List<Integer>> entry : teams.entrySet()){
            System.out.println(String.format("[%d]: %s",entry.getKey(), entry.getValue().toString()));
        }
    }
}
