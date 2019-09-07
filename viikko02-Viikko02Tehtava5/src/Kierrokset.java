import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Kierrokset {
    int lol;

    int laske(int[] t) {
        List list = Arrays.stream(t)
                .boxed()
                .collect(Collectors.toList());


        recursion(list, 0, 0, 1);
        return this.lol;


    }

    void recursion(List t, int total, int startIndex, int startFind) {
        int startnewFind = startFind;
        int totalnew = total + 1;
        int biggest = 0;
        List newList = new ArrayList();

        for (int i = startIndex; i < t.size(); i++) {
            if ((int)t.get(i) == startnewFind) {
                startnewFind++;
            } else {
                newList.add(t.get(i));
            }

            if ((Integer) t.get(i) > biggest) {
                biggest = ((Integer) t.get(i)).intValue();
            }
        }

        if (startnewFind > biggest) {
            this.lol = totalnew;
            return;
        }

        recursion(newList, totalnew, 0, startnewFind);
    }

    int firstWay(int[] t) {
        int total = 1;

        for (int i = 1; i < t.length; i++) {
            if (t[i] < t[i - 1]) {
                total++;
            }
        }

        return total;
    }
}
