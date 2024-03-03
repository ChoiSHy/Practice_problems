package Programmers.KAKAO_BLIND_RECRUITMENT_2019.find_route;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[][] data = {
                new int[] {5,3},new int[] {11,5},new int[] {13,3},new int[] {3,5},new int[] {6,1},new int[] {1,3},new int[] {8,6},new int[] {7,2},new int[] {2,2}
        };
        Solution solution = new Solution();
        solution.solution(data);
    }
}
class Node{
    int val;
    int x;
    Node left;
    Node right;
    public Node(int info[]){
        val=info[0];
        x=info[1];
        left= null;
        right=null;
    }
}
class Solution {
    List<int[]> nodes;
    int [][] answer;
    int preIdx=0;
    int postIdx=0;
    Node root;
    public int[][] solution(int[][] nodeinfo) {
        input(nodeinfo);
        sort();
        /*print();*/
        root = new Node(nodes.get(0));
        for (int i = 1;i<nodeinfo.length;i++){
            put(nodes.get(i));
        }
        answer = new int[2][nodeinfo.length];
        preorder(root);

        for (int a : answer[0])
            System.out.print(a+" ");
        System.out.println();
        postorder(root);
        for(int a : answer[1])
            System.out.print(a+" ");

        return answer;
    }
    void preorder(Node cur){
        answer[0][preIdx++] = cur.val;
        if(cur.left!= null)
            preorder(cur.left);
        if(cur.right!= null)
            preorder(cur.right);
    }
    void postorder(Node cur){
        if(cur.left!= null)
            postorder(cur.left);
        if(cur.right!=null)
            postorder(cur.right);

        answer[1][postIdx++] = cur.val;
    }
    void put(int[] info){
        Node cur = root;
        while(true){
            if(info[1] < cur.x){
                if(cur.left == null){
                    cur.left= new Node(info);
                    break;
                }
                else
                    cur = cur.left;
            }else{
                if(cur.right == null){
                    cur.right = new Node(info);
                    break;
                }
                else
                    cur = cur.right;
            }
        }
    }
    void input(int[][] nodeinfo) {
        nodes = new ArrayList<>();
        int idx = 0;
        for(int[] pos : nodeinfo)
            nodes.add(new int[]{++idx, pos[0], pos[1]});
    }
    void sort(){
        nodes.sort((A,B)->{
            if(A[2] == B[2])
                return A[1]-B[1];
            return B[2] - A[2];
        });
    }
    /*
    void print(){
        for(int[] node : nodes)
            System.out.println(String.format("[%d] (%d, %d)", node[0], node[1], node[2]));
    }*/

}
