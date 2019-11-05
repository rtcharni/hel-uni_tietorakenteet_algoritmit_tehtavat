import java.util.*;

public class Nopanheitto {
    long[] nopatArr;
    public long laske(int n) {
        nopatArr = new long[100];
        laskeNopatArr(n);
        return nopatArr[n];
    }

    void laskeNopatArr(int n) {
        nopatArr[1] = 1;
        nopatArr[2] = 2;
        nopatArr[3] = 4;
        nopatArr[4] = 8;
        nopatArr[5] = 16;
        nopatArr[6] = 32;
        for (int i = 7; i <= n; i++) {
            nopatArr[i] = nopatArr[i-1] + nopatArr[i-2] + nopatArr[i-3] + nopatArr[i-4] + nopatArr[i-5] + nopatArr[i-6];
        }
    }

//    long laskeYksi(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        if (n == 4) {
//            return 8;
//        }
//    }
}
//    tornit(n) = tornit(n - 1) + tornit(n - 2) + tornit(n - 3);