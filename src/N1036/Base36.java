package N1036;

public class Base36 {
	int[] value;
	int digit;

	public Base36() {
		digit = 0;
		value = new int[50];
	}

	public Base36(String s) {
		digit = s.length();
		value = new int[digit];

		for (int i = 0; i < digit; i++) {
			value[i] = Base36_value.char_to_int(s.charAt(digit - 1 - i));
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = digit - 1; i >= 0; i--)
			sb.append(Base36_value.int_to_char(value[i]));

		return sb.toString();
	}
}

class Base36_value {

	public static int char_to_int(char c) {
		if ('A' <= c && c <= 'Z') {
			return c - 'A' + 10;
		} else if ('0' <= c && c <= '9')
			return c - '0';
		else
			return -1;
	}

	public static char int_to_char(int i) {
		if (10 <= i && i <= 35)
			return (char) (i + 'A' - 10);
		else if (0 <= i && i <= 9)
			return (char) (i + '0');
		else
			return ' ';
	}

	public static Base36 add(Base36 a, Base36 b) {
		Base36 ret = new Base36();
		int i1 = 0, i2 = 0, i = 0;

		while (i1 < a.digit || i2 < b.digit) {
			int A = i1 < a.digit ? a.value[i1++] : 0;
			int B = i2 < b.digit ? b.value[i2++] : 0;
			int res = A + B + ret.value[i];
			if (res > 35) {
				if (i < 49)
					ret.value[i + 1]++;
				res -= 36;
			}
			ret.value[i++] = res;
		}
		return ret;
	}
}
