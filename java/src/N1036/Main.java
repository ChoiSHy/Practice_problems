package N1036;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Main {
	static Map<Character, BigInteger> influence;
	static Set<Character> toZ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		influence = new HashMap<>();
		toZ = new HashSet<>();
		String[] words;
		int n, k;
		n = Integer.parseInt(br.readLine());
		words = new String[n];
		for (int i = 0; i < n; i++)
			words[i] = br.readLine();
		k = Integer.parseInt(br.readLine());

		if (k > 0) {
			for (int i = 0; i < n; i++)
				countChar(words[i]);
			List<Map.Entry<Character, BigInteger>> entryList = new ArrayList<>(influence.entrySet());
			entryList.sort(new Comparator<Map.Entry<Character, BigInteger>>() {
				@Override
				public int compare(Map.Entry<Character, BigInteger> o1, Map.Entry<Character, BigInteger> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			int idx = 0;
			for (Map.Entry<Character, BigInteger> entry : entryList) {
				if (idx++ == k)
					break;
				toZ.add(entry.getKey());
			}
		}
		BigInteger res = sum(words,n);
		System.out.println(to36(res));
	}

	static void countChar(String word) {
		int len = word.length();
		int digit = 0;
		for (int i = len - 1; i >= 0; i--) {
			char c = word.charAt(i);
			BigInteger count = new BigInteger("36");
			count = count.pow(digit++);
			count = count.multiply(BigInteger.valueOf(
					35 - Integer.parseInt(Character.toString(c), 36)
			));
			if (influence.containsKey(c))
				count = count.add(influence.get(c));
			influence.put(c, count);
		}
	}

	static BigInteger sum(String[] words, int n) {
		BigInteger result = BigInteger.ZERO;
		for (int i = 0; i < n; i++) {
			String word = words[i];
			result = result.add(valueOf(word));
		}
		return result;
	}

	static BigInteger valueOf(String word){
		int len = word.length();
		BigInteger res = BigInteger.ZERO;

		for(int i =0;i<len;i++){
			char c = word.charAt(i);
			BigInteger digit = new BigInteger("36").pow(len-i-1);
			BigInteger value;
			if(toZ.contains(c))
				value = new BigInteger("35");
			else
				value = BigInteger.valueOf(Integer.parseInt(
						Character.toString(c), 36));

			res = res.add(value.multiply(digit));
		}
		return res;
	}
	static String to36(BigInteger num){
		StringBuilder sb = new StringBuilder();
		BigInteger n36 = BigInteger.valueOf(36);
		if(num.equals(BigInteger.ZERO))
			sb.append(0);
		else{
			while(num.compareTo(BigInteger.ZERO)!=0){
				sb.append(Integer.toString(
						num.remainder(n36).intValue()
						,36).toUpperCase());
				num = num.divide(n36);
			}
		}
		return sb.reverse().toString();
	}
}
