package N1354;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Long, Long> val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n;
        long p, q, x, y;

        String[] inputs = br.readLine().split(" ");
        n = Long.parseLong(inputs[0]);
        p = Long.parseLong(inputs[1]);
        q = Long.parseLong(inputs[2]);
        x = Long.parseLong(inputs[3]);
        y = Long.parseLong(inputs[4]);
        val = new HashMap<>();
        getKeys(n, p, q, x, y);
        List<Long> keys = new ArrayList<>(val.keySet());
        Collections.sort(keys);

        val.put(0L, 1L);
        for (long i : keys) {
            if (val.containsKey(i) && i!=0) {
                long a = i/p-x;
                long b = i/q-y;
                if(a<=0) a=0;
                if(b<=0) b=0;

                val.put(i, val.get(a) + val.get(b));
            }
        }
        System.out.println(val.get(n));
    }

    static void getKeys(long n, long p, long q, long x, long y) {
        if (!val.containsKey(n)) {
            long a = n / p - x;
            long b = n / q - y;
            if (a <= 0) a = 0;
            if (b <= 0) b = 0;
            val.put(n, 0L);
            if (a > 0)
                getKeys(a, p, q, x, y);
            if (b > 0)
                getKeys(b, p, q, x, y);
        }
    }

}
