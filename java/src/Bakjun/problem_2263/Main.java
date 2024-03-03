package Bakjun.problem_2263;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] inorder = null;
    static int[] postorder = null;

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tok = null;
        try {
            int n = Integer.parseInt(br.readLine());
            inorder = new int[n];
            postorder = new int[n];

            tok = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                inorder[i] = Integer.parseInt(tok[i]);
            tok = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                postorder[i] = Integer.parseInt(tok[i]);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

