package Programmers.JavaCodingTest.p6_graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        double dis = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return dis;
    }
}

public class graphTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            Solution s = new Solution();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] xs = new int[n];
            int[] ys = new int[n];
            int[][] linked = new int[m][2];
            for (int j = 0; j < n; j++)
                xs[j] = scanner.nextInt();
            for (int j = 0; j < n; j++)
                ys[j] = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                linked[j][0] = scanner.nextInt();
                linked[j][1] = scanner.nextInt();
            }

            Point[] vtxs = new Point[n];
            for (int j = 0; j < n; j++)
                vtxs[j] = new Point(xs[j], ys[j]);

            s.solution(n, vtxs, linked);
        }
    }
}

class Solution {
    int n;
    double[][] D;
    Point[] vtxs;

    public void solution(int n, Point[] vtxs, int[][] linked) {
        D = new double[n][n];
        this.n = n;
        this.vtxs = vtxs;
        for(int i =0;i<n;i++){
            for(int j = 0 ; j<n; j++){
                if(i==j) continue;
                double dis = vtxs[i].getDistance(vtxs[j]);
                D[i][j] = D[j][i] = dis;
            }
        }
        for (int[] link : linked) {
            int a = link[0];
            int b = link[1];
            double d = 0;
            D[a][b] = D[b][a] = d;
        }
        double res = prim(0);
        System.out.println(res);
    }

    private void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%8.3f\t", D[i][j]));
            }
            System.out.println();
        }
    }

    private double prim(int start) {
        double sum = 0;
        int cnt=0;
        double[] dis = new double[n];
        Set<Integer> visit = new HashSet<>();
        Arrays.fill(dis, Integer.MAX_VALUE);
        int cur = start;

        System.out.println(String.format("%d 방문",cur));
        while (cnt < n-1) {
            cnt++;
            double min = Double.MAX_VALUE-1;
            int minIdx=cur;
            for (int i = 0; i < n; i++) {
                if (i == cur) continue;
                if(dis[i] > D[cur][i])
                    dis[i] =D[cur][i];
                if (dis[i] < min && !visit.contains(i)){
                    min = dis[i];
                    minIdx = i;
                }
            }
            visit.add(cur);
            cur = minIdx;
            System.out.print(String.format("min: %.3f\t",min));
            System.out.println(String.format("%d 방문",cur));
            sum += min;
        }
        return sum;
    }
}
