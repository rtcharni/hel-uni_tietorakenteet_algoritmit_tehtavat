import java.util.*;

public class VainYksi {
    int etsi(int[] t) {
        Arrays.sort(t);
        int last = 0;
        int count = 0;
        for (int i = 0; i < t.length; i++) {
            if (last == t[i]) {
                count++;
            } else {
                if (count == 1) {
                    return last;
                } else {
                    last = t[i];
                    count = 1;
                }
            }
        }
        return last;
    }
}
