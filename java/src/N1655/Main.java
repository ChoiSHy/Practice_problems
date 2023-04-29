package N1655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min_heap = new PriorityQueue<>();

		max_heap.add(Integer.parseInt(br.readLine()));
		sb.append(max_heap.peek()+"\n");
		for (int i = 1; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			if (k < max_heap.peek()) {
				max_heap.add(k);
			}
			else {
				min_heap.add(k);
			}
			if(max_heap.size() < min_heap.size())
				max_heap.add(min_heap.poll());
			else if(max_heap.size() > min_heap.size()+1)
				min_heap.add(max_heap.poll());
			
			sb.append(max_heap.peek()+"\n");
		}
		System.out.println(sb.toString());

	}
}
