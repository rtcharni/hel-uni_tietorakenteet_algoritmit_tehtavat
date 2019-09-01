import java.util.Arrays;
import java.util.stream.Stream;

public class Onnenluvut {
    int laske(int a, int b) {
        int total = 0;
        int length = String.valueOf(b).length();
        // Integer.parseInt("7".repeat(length))
        for (int i = a; i < b; i++) {
            if (String.valueOf(i).chars().mapToObj(z -> (char)z).allMatch(x -> x == '3' || x == '7')) {
                total++;
            }
        }
        
        return total;
    }
}
