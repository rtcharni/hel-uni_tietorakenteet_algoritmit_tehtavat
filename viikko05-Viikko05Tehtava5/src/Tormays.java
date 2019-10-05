import java.util.*;

public class Tormays {
    List<String> list = new ArrayList();
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer,String> map = new HashMap<>();
    String sana1 = "";
    String sana2 = "";
    boolean stop = false;
    int a = 97;
    int b = 98;

    public Tormays() {
        list.add("a");
        list.add("b");
        set.add("a".hashCode());
        set.add("b".hashCode());
        map.put("a".hashCode(), "a");
        map.put("b".hashCode(), "b");

        this.Rec(list, 2);
    }

    String merkkijono1() {
        return this.sana1;
    }

    String merkkijono2() {
        return this.sana2;
    }

    void Rec(List<String> listS, int added) {
        if (stop == true) {
            return;
        }

        List<String> newList =  new ArrayList<>(listS);


        for (int i = listS.size() - 1; i >= listS.size() - added; i--) {
            String a = listS.get(i) + "a";
            String b = listS.get(i) + "b";

            if (set.contains(a.hashCode())) {
                sana1 = map.get(a.hashCode());
                sana2 = a;
                System.out.println("1: " + sana1);
                System.out.println("2: " + sana2);
                stop = true;
                return;
            } else if (set.contains(b.hashCode())) {
                sana1 = map.get(b.hashCode());
                sana2 = b;
                System.out.println("1: " + sana1);
                System.out.println("2: " + sana2);
                stop = true;
                return;
            }

            newList.add(a);
            newList.add(b);
            set.add(a.hashCode());
            set.add(b.hashCode());
            map.put(a.hashCode(), a);
            map.put(b.hashCode(), b);
        }
        Rec(newList, added * 2);


    }
}
