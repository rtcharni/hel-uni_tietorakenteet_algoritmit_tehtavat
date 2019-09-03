import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;

public class Onnenluvut {
    int min, max, total;
    int laske(int a, int b) {
        this.total = 0;
        this.min = a;
        this.max = b;

        recursion("3", 9);
        recursion("7", 9);
        return this.total;
    }

    void recursion(String str, int times) {
        if (times == 0) {
            return;
        } else {
            int num = Integer.parseInt(str);
            if (num >= this.min && num <= this.max) {
                this.total++;
            }
            String new3 = str + "3";
            String new7 = str + "7";
            recursion(new3, times - 1);
            recursion(new7, times - 1);
        }
    }

    int workingWay1(int a, int b) {
        List list = new ArrayList<String>();
        list.add("3");
        list.add("7");


        int added = 2;
        for (int i = 0; i < 8; i++) {
            List temp = new ArrayList<String>();

            for (int j = 1; j <= added; j++) {
                String new3 = list.get(list.size() - j).toString() + "3";
                String new7 = list.get(list.size() - j).toString() + "7";
                temp.add(new3);
                temp.add(new7);
            }

            added *= 2;
            list.addAll(temp);
        }


        int total = 0;
        List finall = new ArrayList<String>();

        list.forEach(item -> {
            if (Integer.parseInt((String) item) >= a && Integer.parseInt((String) item) <= b) {
                finall.add(item);
            }
        });

        return finall.size();
    }
}
