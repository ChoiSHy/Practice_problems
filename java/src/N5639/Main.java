package N5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int val;
    Node left, right;

    public Node(int val){
        this.val = val;
        left = right = null;
    }
}
class Tree{
    Node root;
    List<Integer> inorder;
    Queue<Integer> preorder;
    StringBuilder sb;
    public Tree(){
        root = null;
        inorder = new ArrayList<>();
        preorder = new LinkedList<>();
        sb= new StringBuilder();
    }
    public void set(){
        root = new Node(preorder.poll());
        Collections.sort(inorder);
    }
    public void makeTree(){
        makeTree(root, 0, inorder.size());
    }
    private void makeTree(Node cur, int from, int to){
        if(preorder.isEmpty())
            return;
        int idx = inorder.indexOf(cur.val);
        if(from < idx){
            cur.left= new Node(preorder.poll());
            makeTree(cur.left, from, idx);
        }
        if(idx+1 < to){
            cur.right = new Node(preorder.poll());
            makeTree(cur.right, idx+1, to);
        }
    }
    public void postorder(){
        postorder(root);
        System.out.println(sb.toString());
    }
    private void postorder(Node cur){
        if(cur == null) return;
        postorder(cur.left);
        postorder(cur.right);
        sb.append(cur.val).append("\n");
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree= new Tree();
        String input;
        while(true){
            // It's not able to know how many numbers would come, so when input is null or "" input stage is over.
            input = br.readLine();
            if(input==null || input.equals(""))
                break;
            int i = Integer.parseInt(input);
            tree.preorder.add(i);
            tree.inorder.add(i);
        }
        tree.set();
        tree.makeTree();
        tree.postorder();
    }
}
