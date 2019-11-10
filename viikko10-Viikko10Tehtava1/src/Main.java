import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 5000;
        Saavutettavuus s = new Saavutettavuus(n);
        for (int i = 1; i+1 <= n; i++) s.lisaaYhteys(i,i+1);
        System.out.println(s.laske(1337));
//        if (s.laske(1337) == n-1) return;
//        Saavutettavuus s = new Saavutettavuus(6);
//        s.lisaaYhteys(1,2);
//        s.lisaaYhteys(2,3);
//        s.lisaaYhteys(1,3);
//        s.lisaaYhteys(3,4);
//        s.lisaaYhteys(5,6);
//        System.out.println(s.laske(1)); // 3
    }
}
