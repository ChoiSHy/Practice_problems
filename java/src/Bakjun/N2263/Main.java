package Bakjun.N2263;

import java.util.HashMap;

public class Main {
	static HashMap<Integer, Integer> tree = new HashMap<>();
	static StringBuilder sb;

	public static void main(String[] args) {
		

		sb = new StringBuilder();
		makeSET();
		makepre(1);
		System.out.println(sb);

	}
	static void makeSET() {
		tree.put(1, 1);
		tree.put(2, 2);
		tree.put(3, 3);
		tree.put(4, 4);
		tree.put(5, 5);
		tree.put(6, 8);
		tree.put(7, 9);
		tree.put(10, 6);
		tree.put(11, 7);
		tree.put(14, 10);
	}

	static void makepre(int idx) {
		if (!tree.containsKey(idx))
			return;

		sb.append(tree.get(idx));
		makepre(idx*2);
		makepre(idx*2+1);

	}

}
