package Programmers.Get_Item;


import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean is_limit() {
        if (1 > x || 100 < x) return true;
        else if (1 > y || 100 < y) return true;
        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point other = (Point) o;
        return other.x == x && other.y == y;
    }

    @Override
    public int hashCode() {
        int res = (int) (x ^ (x >>> 32));
        res = 31 * res + (int) (y ^ (y >>> 32));

        return res;
    }
    public String toString(){return String.format("[%d, %d]",x,y);}
}

class Solution {
    Map<Point, Integer> visit;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        visit = new HashMap<>();
        Point cur = new Point(characterX*2, characterY*2);
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(cur);
        visit.put(cur, 0);
        /* bfs */
        while (!queue.isEmpty()) {
            cur = queue.remove(); // 현재 위치
            //System.out.println(cur);
            if (visit.containsKey(cur)) {
                int distance = visit.get(cur) + 1;
                for (int i = 0; i < 4; i++) {   // 4방위를 확인
                    Point next = new Point(cur.x + dir[i][0], cur.y + dir[i][1]);
                    if(!next.is_limit() && is_on_rect(next, rectangle) && !visit.containsKey(next) && !is_in_rect(next,rectangle)){
                        //System.out.println("\t"+next);
                        queue.add(next);
                        visit.put(next, distance);
                    }
                }
            }
        }
        int answer = visit.get(new Point(itemX*2, itemY*2))/2;
        System.out.println("answer: "+answer);
        return answer;
    }
    boolean is_on_rect(Point p, int[][] rects){
        for (int[] rect : rects){
            int x1 = rect[0]*2;
            int y1 = rect[1]*2;
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;

            if(p.x == x1 || p.x == x2)
                if(y1 <= p.y && p.y <= y2)
                    return true;
            if(p.y == y1 || p.y == y2)
                if(x1<= p.x && p.x <= x2)
                    return true;
        }
        return false;
    }
    boolean is_in_rect(Point p, int[][] rects){
        for(int[] rect : rects){
            int x1 = rect[0]*2;
            int y1 = rect[1]*2;
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;

            if(x1 < p.x && p.x < x2)
                if(y1 < p.y && p.y < y2)
                    return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8);
        s.solution(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7, 6, 1);

        s.solution(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7);
        //s.solution(new int[][]{{1, 1, 4, 2}}, 2, 1, 2, 2);

        s.solution(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10);
        //s.solution(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10);

        s.solution(new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3);
    }
}
