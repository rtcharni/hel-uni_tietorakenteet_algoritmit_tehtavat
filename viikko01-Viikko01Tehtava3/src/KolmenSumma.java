import java.util.ArrayList;
import  java.util.List;
import java.util.*;

public class KolmenSumma {

    int laske(int x) {
        if (x < 6) {
            return 0;
        }

        ArrayList<int[]> allArrays = new ArrayList<int[]>();

        for (int i = 1; i <= x; i++) {

            for (int j = 1; j <= x; j++) {
                int lastNum = x - i - j;
                if (lastNum < 1 || i == j || lastNum == i || lastNum == j) {
                    continue;
                }

                int[] combination = {i, j, lastNum};
                Arrays.sort(combination);

                if (isInList(allArrays, combination)) {
                    continue;
                }

                allArrays.add(combination);
            }
        }

        return allArrays.size();

    }

    public static boolean isInList(
            final List<int[]> list, final int[] candidate){

        for(final int[] item : list){
            if(Arrays.equals(item, candidate)){
                return true;
            }
        }
        return false;
    }
}
