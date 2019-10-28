import java.util.*;

public class Osajoukot {  
    int total;
    public int laske(int[] t, int x) {
        total = 0;
        haku(0, t, new int[t.length + 10], x);
        return total;
    }

    void haku(int k, int[] t, int[] uusiT, int x) {
        if (k == t.length) {
            //käsittele loputulos
            long totall = 0;
            for (int i = 0; i < t.length; i++) {
                if (uusiT[i] != 0) {
                    totall += t[i];
                }
            }
            if (totall == x) {
                total++;
            }
        } else {
            for (int i = 0; i <= 1 ; i++) {
                uusiT[k] = i;
                haku(k+1, t, uusiT, x);
            }


        }
    }
}
