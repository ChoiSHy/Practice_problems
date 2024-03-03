package Bakjun.N1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWord {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String word;

		for (int i = 0; i < n; i++) {
			word = br.readLine();

			if (check(word))
				count++;
		}
		System.out.println(count);
	}

	public static boolean check(String word) {
		char std = '0';
		boolean[] list = new boolean[26];

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (std != c) { // �տ��Ͱ� �ٸ� ���
				if (list[c - 'a'] == true) // �տ��� ��� �� �� ������
					return false;

				else {
					std = c;
					list[c - 'a'] = true;
				}
			}

		}
		return true;
	}

}
