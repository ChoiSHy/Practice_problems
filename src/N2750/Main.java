package N2750;

import java.util.Scanner;

class heap {
	int count;
	int[] arr;

	public heap(int n) {
		count = 0;
		arr = new int[n + 1];
	}

	public void insert_heap(int x) {
		if (count == arr.length)
			return;
		int i = ++count;

		while (i != 1 && arr[i / 2] > x) {
			arr[i] = arr[i / 2];
			i /= 2;
		}
		arr[i] = x;
	}

	public int delete_heap() {
		arr[0] = arr[1];
		arr[1] = arr[count--];

		int i = 1;
		while (i <= count) {
			if (i * 2 + 1 > count && i * 2 <= count) { // 가지 1개
				if (arr[i * 2] < arr[i]) {
					swap(i * 2, i);
					i *= 2;
				}else return arr[0];
			}
			else if(i*2+1<=count){ // 가지 2개
				if (arr[i * 2] < arr[i * 2 + 1]) {
					if (arr[i * 2] < arr[i]) {
						swap(i * 2, i);
						i *= 2;
					}
					else return arr[0];
				} else {
					if (arr[i * 2 + 1] < arr[i]) {
						swap(i * 2 + 1, i);
						i = i * 2 + 1;
					}
					else return arr[0];
				}
			}
			else
				i*=2;
		}
		return arr[0];
	}

	public void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		
		heap h = new heap(n);
		
		for(int i=0;i<n;i++)
			h.insert_heap(scan.nextInt());
		
		for(int i=0;i<n;i++) {
			System.out.println(h.delete_heap());
		}
	}
}
