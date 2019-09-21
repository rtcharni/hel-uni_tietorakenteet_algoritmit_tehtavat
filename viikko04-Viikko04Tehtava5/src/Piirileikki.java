import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Piirileikki {
    int last;
    int viimeinen(int n) {
        last = 0;
        LinkedList linked = new LinkedList();
        ArrayList list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            linked.add(i);
        }
        rec(list, false);
        return this.last;


    }

    void rec(ArrayList list, boolean removeFirst) {
        ArrayList newList = new ArrayList();
        boolean removeNext = true;

        for (int i = 0; i < list.size(); i++) {
            if (removeFirst) {
                if (i == 0) {
                    removeNext = true;
                    continue;
                }
            }
            if (removeNext) {
                newList.add(list.get(i));
                removeNext = false;
                continue;
            }
            removeNext = true;
        }

        if (newList.size() == 1) {
            this.last = (int)newList.get(0);
            return;
        }
        if (removeNext) {
            rec(newList, false);
        } else {
            rec(newList,true);
        }
    }
}
