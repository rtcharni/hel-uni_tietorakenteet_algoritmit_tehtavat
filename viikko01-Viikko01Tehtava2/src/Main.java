import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Osajonot o = new Osajonot();
            System.out.println(o.laske("aybabtu","bab")); // 1
            System.out.println(o.laske("aaaaa","aa")); // 4
            System.out.println(o.laske("apina","banaani")); // 0
        } catch (Exception ex){
            System.out.println("Virhe " + ex.getMessage());
        }

    }
}
