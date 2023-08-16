package N1351;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Long, Long> val;
    static Map<Long, long[]> exp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n;
        long p, q;
        String[] inputs = br.readLine().split(" ");
        n = Long.parseLong(inputs[0]);
        p = Long.parseLong(inputs[1]);
        q = Long.parseLong(inputs[2]);
        val = new HashMap<>();
        exp = new HashMap<>();
        getKeys(n, p, q);

        List<Long> keys = new ArrayList<>(exp.keySet());
        Collections.sort(keys);
        val.put(0L, 1L);
        val.put(1L, 2L);
        for (long i : keys) {
            if (!val.containsKey(i)) {
                long[] value = exp.get(i);
                long a = val.get(value[0]);
                long b = val.get(value[1]);
                val.put(i, a + b);
            }
        }
        System.out.println(val.get(n));
    }

    static void getKeys(long n, long p, long q) {
        if (!exp.containsKey(n)) {
            exp.put(n, new long[]{n / p, n / q});
            if (n / p > 1)
                getKeys(n / p, p, q);
            if (n / q > 1)
                getKeys(n / q, p, q);
        }
    }

}
