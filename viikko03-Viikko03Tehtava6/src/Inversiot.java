import java.util.*;

public class Inversiot {
    int[] muodosta(int n, long k) {
        int[] arr = new int[n];
        int biggestNum = n;
        int smallestNum = 1;
        int minusNum = 1;
        long inversiot = k;
        int continueFromIndex = 0;

        for (int i = n; i > 0; i--) {
            int inv = n - minusNum;
            if (inv > inversiot) {
                // meni yli, älä laita tätä inversioksi
                arr[i - 1] = biggestNum;
                biggestNum--;
                minusNum++;
            } else if (inv == inversiot) {
                arr[i - 1] = smallestNum;
                // Laita loput oikeassa järjestyksessä BREAK AND DO SOMETHING
                continueFromIndex = i - 2;
                break;
            } else {
                arr[i - 1] = smallestNum;
                smallestNum++;
                minusNum++;
                inversiot -= inv;
                // tarvitaan lisää inversioita
            }
        }

        for (int i = continueFromIndex; i >= 0; i--) {
            arr[i] = biggestNum;
            biggestNum--;
        }

        return arr;
    }
}
