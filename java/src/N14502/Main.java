package N14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Node o = (Node) obj;
        return x == o.x && y == o.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    static int n, m;
    static int[][] field;
    static Map<Node, List<Node>> vlist;
    static int[][] pos = new int[][]{
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        field = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        vlist = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(field[i][j] == 2 || field[i][j] == 0){
                    vlist.put(new Node(i,j), new ArrayList<>());
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
