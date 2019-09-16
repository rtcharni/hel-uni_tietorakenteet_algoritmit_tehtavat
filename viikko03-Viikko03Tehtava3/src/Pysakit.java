import java.util.*;

public class Pysakit {
    int laske(int[] t, int k) {
        Arrays.sort(t);
        int pysakit = 0;
        int viimPysakki = 0;
        for (int i = 0; i < t.length; i++) {
            if (i == 0) {
                pysakit++;
                viimPysakki = t[0] + k;
                continue;
            }

            if (viimPysakki < t[i] - k) {
                pysakit++;
                viimPysakki = t[i] + k;
            } else {
                continue;
            }
        }
        return pysakit;
    }

    int firstWay(int[] t, int k) {
        Arrays.sort(t);
        int pysakit = 0;
        int lastI = 0;
        int skipped = 0;
        for (int i = 1; i < t.length; i++) {
            int now = t[i];
            int last = t[lastI];
            int diff = now - last;
            if (diff / 2 > k) {
                //ei mahdu
                pysakit++;
                lastI = i;
                skipped = 0;
                if (i == t.length - 1) {
                    pysakit++;
                    break;
                }
            } else if (diff / 2 == k) {
                //mahtuu tasan tarkalleen väliin
                pysakit++;
                if (i == t.length - 1) {
                    break;
                } else if (i == t.length - 2) {
                    pysakit++;
                    break;
                }
                lastI = i + 1;
                i++;
                skipped = 0;
            } else {
                //mahtuu ja menee ylikin
                skipped++;
                lastI = i - skipped;
            }


            //Jos vika rundi!
            if (i == t.length - 1) {
                if (skipped > 0) {
                    pysakit++;
                }
            }
            //Jos i meni yli
            if (i >= t.length) {
                pysakit++;
            }
        }

        return pysakit;
    }
}
