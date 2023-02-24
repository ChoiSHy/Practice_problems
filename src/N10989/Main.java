package N10989;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());

		int[] arr = new int[size];
		int[] res = new int[size];
		int[] cnt = new int[10001];

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			cnt[arr[i]]++;
		}
		for (int i = 1; i < 10001; i++)
			cnt[i] = cnt[i] + cnt[i - 1];

		for (int i = size - 1; i >= 0; i--)
			res[--(cnt[arr[i]])] = arr[i];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) 
			sb.append(res[i]).append("\n");
		
		System.out.println(sb);
	}
}
