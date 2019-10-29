import java.util.*;

public class Permutaatiot {  
    int total;
    public int laske(int n) {
        total = 0;
        haku(1, n, new boolean[n + 2], new int[n + 2]);
        return total;
    }

    void haku(int k, int n, boolean[] mukana, int[] luvut) {
        if (k == n + 1) {
            total++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (k == 1) {
                    if (!mukana[i]) {
                        mukana[i] = true;
                        luvut[k] = i;
                        haku(k+1, n, mukana, luvut);
                        mukana[i] = false;
                    }
                } else {
                    if (!mukana[i] && Math.abs(luvut[k - 1] - i) != 1) {
                        mukana[i] = true;
                        luvut[k] = i;
                        haku(k+1, n, mukana, luvut);
                        mukana[i] = false;
                    }
                }

            }
        }
    }
}
