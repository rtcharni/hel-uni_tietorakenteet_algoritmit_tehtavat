import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Ruudukko r = new Ruudukko(4);
//        System.out.println(r.laskeHuoneet()); // 0
//        r.teeLattia(1,1);
//        r.teeLattia(1,3);
//        System.out.println(r.laskeHuoneet()); // 2
//        r.teeLattia(1,2);
//        System.out.println(r.laskeHuoneet()); // 1
//        r.teeLattia(3,3);
//        System.out.println(r.laskeHuoneet()); // 2
        int n = 500;
        int m = 100000;
        Ruudukko r = new Ruudukko(n);
        Random x = new Random(1337);
        long c = 0;
        for (int i = 1; i <= m; i++) {
            int a = x.nextInt(n)+1;
            int b = x.nextInt(n)+1;
            r.teeLattia(a,b);
            c += r.laskeHuoneet();
        }
        System.out.println(c);
//        if (c != 2472002837L) virhe();
    }
}
