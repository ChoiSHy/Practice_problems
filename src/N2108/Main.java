package N2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class countSort {
	int arr[];
	int res[];
	int cnt[];
	int size;
	int max, min;

	public countSort(int size) {
		this.size = size;
		this.arr = new int[size];
		this.res = new int[size];
		this.cnt = new int[8001];
		this.min = 4000;
		this.max = -4000;
	}

	public void input(int i, int n) {
		arr[i] = n;
		cnt[n + 4000]++;

		if (n > max)
			max = n;
		if (n < min)
			min = n;
	}

	public void sort() {
		for (int i = 1; i < 8001; i++)
			cnt[i] = cnt[i] + cnt[i - 1];

		for (int i = size - 1; i >= 0; i--)
			res[--(cnt[arr[i] + 4000])] = arr[i];
	}

	public int average() {
		int sum = 0;
		for (int i : arr)
			sum += i;
		double round = (double) Math.round((double) sum / (double) size);
		return (int) round;
	}

	public int middle() {
		return res[size / 2];
	}

	public int most() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = cnt[0];
		list.add(-4000);
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[i] == max)
				list.add(i - 4000);
			else if (cnt[i] > max) {
				max = cnt[i];
				list.clear();
				list.add(i - 4000);
			}
		}
		if (list.size() > 1) {
			Collections.sort(list);
			return list.get(1);
		} else
			return list.get(0);
	}

	public int diff() {
		return max - min;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		if (size <= 0) {
			System.out.println(0);
			System.out.println(0);
			System.out.println(0);
			System.out.println(0);
		} else {
			countSort cs = new countSort(size);

			for (int i = 0; i < size; i++)
				cs.input(i, Integer.parseInt(br.readLine()));

			int most = cs.most();
			cs.sort();
			System.out.println(cs.average());
			System.out.println(cs.middle());
			System.out.println(most);
			System.out.println(cs.diff());
		}
	}
}
