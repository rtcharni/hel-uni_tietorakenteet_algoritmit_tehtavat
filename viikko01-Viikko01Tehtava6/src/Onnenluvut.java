import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;

public class Onnenluvut {
    int laske(int a, int b) {
        int total = 0;
        int maxLengthInt = String.valueOf(b).length();
        int minLengthInt = String.valueOf(a).length();

        for (int i = minLengthInt; i <= maxLengthInt; i++) {
            int added = 0;
            int maxPosibilityCount = ((int) Math.pow(2, i));
            for (int j = Integer.parseInt("3".repeat(i)); j <= Integer.parseInt("7".repeat(i)); j++) {

                if ((String.valueOf(j).toCharArray()[0] != '3' && String.valueOf(j).toCharArray()[0] != '7') || j < a || j > b) {
                    continue;
                } else if (String.valueOf(j).chars().mapToObj(z -> (char) z).allMatch(x -> x == '3' || x == '7')) {
                    total++;
                    added++;

                    if (added == maxPosibilityCount) {
                        break;
                    }
                }

            }
        }
        return total;
    }

    int firstWay(int a, int b) {
        long startTime = System.nanoTime();

        int total = 0;
        // int length = String.valueOf(b).length();
        // Integer.parseInt("7".repeat(length))
        for (int i = a; i <= b; i++) {
            if (String.valueOf(i).toCharArray()[0] != '3' && String.valueOf(i).toCharArray()[0] != '7') {
                continue;
            } else if (String.valueOf(i).chars().mapToObj(z -> (char) z).allMatch(x -> x == '3' || x == '7')) {
                total++;
            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        return total;
    }
}
