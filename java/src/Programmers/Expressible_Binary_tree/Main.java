package Programmers.Expressible_Binary_tree;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new long[]{
                7, 42, 5
        });
        s.solution(new long[]{
                63,111,95,511
        });
    }
}

class Solution {
    boolean[] tree;

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx=0;
        for (long number : numbers)
            answer[idx++] = solve(number);

        for(int i : answer)
            System.out.print(i+"\t");
        System.out.println();
        return answer;
    }

    private int solve(long number) {
        tree = toCompleteTree(number);
        return search(0, tree.length - 1) ? 1 : 0;
    }

    private boolean search(int left, int right) {
        int mid = (left + right) / 2;
        int next = -1;
        boolean ret = true;
        if (tree[mid]) {  // 1
            if (outOfIndex(left, mid - 1) != -1)
                ret &= search(left, mid - 1);
            if (outOfIndex(mid+1, right) != -1)
                ret &= search(mid + 1, right);
        } else {           // 0
            if ((next = outOfIndex(left, mid - 1)) != -1) {
                if (tree[next])
                    return false;
                ret &= search(left, mid-1);
            }
            if ((next = outOfIndex(mid + 1, right)) != -1) {
                if (tree[next])
                    return false;
                ret &= search(mid+1, right);
            }
        }
        return ret;
    }

    private int outOfIndex(int left, int right) {
        if (left <= right && 0 <= left && right < tree.length)
            return (left + right) / 2;
        return -1;
    }

    private boolean[] toCompleteTree(long number) {
        String binStr = Long.toString(number, 2);
        int len = (int) Math.pow(2, log2(binStr.length()) + 1) - 1;
        binStr = String.format("%" + len + "s", binStr);
        boolean[] res = new boolean[binStr.length()];
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1')
                res[i] = true;
        }
        return res;
    }

    private int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}