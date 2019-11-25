import java.util.*;

public class Main {
    public static void main(String[] args) {
        Reitit r = new Reitit(5);
        r.lisaaKaari(1,2);
        r.lisaaKaari(2,3);
        r.lisaaKaari(2,4);
        r.lisaaKaari(3,5);
        r.lisaaKaari(4,5);
        System.out.println(r.laske()); // 2
    }
}
