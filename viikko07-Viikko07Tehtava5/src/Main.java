import java.util.*;

public class Main {
    public static void main(String[] args) {
        Lukujono l = new Lukujono();
        System.out.println(l.laske(1)); // 2
        System.out.println(l.laske(2)); // 3
        System.out.println(l.laske(3)); // 4
        System.out.println(l.laske(10)); // 15
        System.out.println(l.laske(100)); // 1600
    }
}
