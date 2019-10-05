import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HatutJaPallot {
    //int arr[] = new int[1000000000];
    HashMap<Integer,Integer> kirja = new HashMap<>();
    int suurin = 0;
    int yksi = 0;
    
    void lisaaPallo(int x) {
//        arr[x] += 1;
        if (kirja.containsKey(x)) {
            int a = kirja.get(x) + 1;
            kirja.put(x, a);
            if (a > suurin) {
                suurin = a;
            }
        } else {
            kirja.put(x, 1);
            yksi++;
            if (suurin == 0) {
                suurin = 1;
            }
        }

    }
    
    int monessakoYksi() {
//        int total = 0;
//
//        for (Map.Entry<Integer, Integer> entry : kirja.entrySet()) {
//            if (entry.getValue() >= 1) {
//                total++;
//            }
//        }
//
//        return total;
        return yksi;
    }
    
    int suurinMaara() {
//        int biggest = 0;
//
//        for (Map.Entry<Integer, Integer> entry : kirja.entrySet()) {
//            if (entry.getValue() > biggest) {
//                biggest = entry.getValue();
//            }
//        }
//        return biggest;
        return suurin;
    }
}
