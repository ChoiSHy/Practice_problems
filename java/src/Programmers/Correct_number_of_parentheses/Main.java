package Programmers.Correct_number_of_parentheses;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2));
        System.out.println(s.solution(3));

    }
}

class Solution {
    public int solution(int n) {
        Node root = new Node(n, n);

        int answer = root.count();
        return answer;
    }
}

class Node {
    Node leftNode;
    Node rightNode;

    public Node(int left, int right) {
        leftNode = rightNode = null;
        if (left > 0) {
            leftNode = new Node(left - 1, right);
        }
        if (left < right && right > 0) {
            rightNode = new Node(left, right - 1);
        }
    }

    public int count() {
        if(leftNode == null && rightNode == null)
            return 1;
        int ret = 0;
        if (leftNode != null) ret += leftNode.count();
        if (rightNode != null) ret += rightNode.count();
        return ret;
    }
}

