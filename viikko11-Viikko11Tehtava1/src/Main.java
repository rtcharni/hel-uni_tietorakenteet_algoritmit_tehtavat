
public class Main {
    public static void main(String[] args) {
        LyhinReitti l = new LyhinReitti(5);
        l.lisaaTie(1,2,7);
        l.lisaaTie(2,4,2);
        l.lisaaTie(1,3,6);
        l.lisaaTie(3,4,5);
        l.lisaaTie(4,5,3);
        System.out.println(l.laske(1,5)); // 12
//        LyhinReitti l = new LyhinReitti(2);
//        l.lisaaTie(1,1,1);
//        l.lisaaTie(2,2,1);
//        l.lisaaTie(1,2,1);
//        System.out.println(l.laske(1,2));
//
//        fail("Luokkasi toimii väärin, kun tien päissä on sama kaupunki");
    }
}
