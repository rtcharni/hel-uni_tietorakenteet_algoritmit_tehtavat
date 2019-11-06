import java.util.*;

public class Kolikot {
    boolean[] painotArr;
    public int laske(int[] t) {
        int max = laskeMax(t);
        int min = laskeMin(t);

        painotArr = new boolean[max * 4];
        painot(t.length, max, min,t);
        int total = 0;

        for (int i = 0; i < max; i++) {
            if (painotArr[i]) {
                total++;
//                System.out.println(i);
            }
        }

//        System.out.println("YHT" + total);

        return total + 1;
    }

    void painot(int n, int max, int min, int[] p) {
        painotArr[min] = true;
        for (int i = 0; i < n; i++) {
            for (int j = max; j >= 0; j--) {
                if (painotArr[j]) {
                    painotArr[j+p[i]] = true;
                }
            }
        }
    }

    int laskeMax(int[] t) {
        int total = 0;
        for (int i = 0; i < t.length; i++) {
            total += t[i];
        }
        return total;
    }

    int laskeMin(int[] t) {
        int min = 9999999;
        for (int i = 0; i < t.length; i++) {
            if (t[i] < min) {
                min = t[i];
            }
        }
        return min;
    }
}
