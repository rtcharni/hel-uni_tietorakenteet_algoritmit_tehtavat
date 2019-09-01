import java.util.*;

public class Taulukko {
    int laske(int[] t) {
        int[] temp = t;

        while (true) {
            if (temp.length == 1) {
                return temp[0];
            } else if (temp.length == 2) {
                return temp[0] + temp[1];
            } else {
                // 3 or more
                List<Integer> list = new ArrayList<>();

                for (int i = 1; i < temp.length; i++) {
                    list.add(temp[i] + temp[i - 1]);
                }

                temp = list.stream().mapToInt(i -> i).toArray();

            }

        }
    }
}
