import java.util.*;

public class Summahaku {
    long laske(int[] t, int x) {

        long[] s = new long[t.length];
        HashMap<Long, Integer> map = new HashMap();

        long summa = 0;
        for (int i = 0; i < t.length; i++) {
            summa += t[i];

            if (map.containsKey(summa)) {
                map.put(summa, map.get(summa) + 1);
            } else {
                map.put(summa, 1);
            }

            s[i] = summa;
        }

        long total = 0;

        for (int i = 0; i < t.length; i++) {
            if (t[i] == x) {
                total++;
            }

            long z = x - t[i] + s[i];

            if (map.containsKey(s[i])) {
                int a = map.get(s[i]);
                if (a > 0) {
                    map.put(s[i], a - 1);
                }
            }

            if (map.containsKey(z)) {
                int a = map.get(z);
                if (a > 0) {
                    total += a;
                }
            }
        }
        return total;
    }
}