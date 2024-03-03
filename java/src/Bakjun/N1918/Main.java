package Bakjun.N1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

// () > */ > +-
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('+', 0);
        priority.put('-', 0);
        priority.put('*', 1);
        priority.put('/', 1);
        priority.put('(', -1);

        char[] exp;
        try {
            exp = br.readLine().toCharArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (char c : exp) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.isEmpty()) {
                        char p = stack.pop();
                        if (p == '(')
                            break;
                        sb.append(p);
                    }
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c))
                        sb.append(stack.pop());
                    stack.push(c);
                    break;
                default:
                    sb.append(c);
                    break;
            }

        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb.toString());
    }
}
