import java.util.ArrayList;
import java.util.List;

public class Alitaulukot {
    int[] counter;
    List list;

    long laske(int[] t) {
        this.counter = new int[1000001];
        this.list = new ArrayList<Integer>();

        int start = 0;
        long sum = 0;

        for (int end = 0; end < t.length; end++) {
            int num = t[end];

            if (!this.list.contains(num)) {
                if (this.list.size() < 2) {
                    this.list.add((int)num);
                    this.counter[num] = 1;
                } else {
                    sum += this.countSubarrays(start, end);
                    start = this.moveStartIdx(start, t);
                    sum -= this.countSubarrays(start, end);
                    this.counter[num] = 1;
                    this.list.add(num);
                }
            } else {
                this.counter[num]++;
            }
        }
        sum += this.countSubarrays(start, t.length);

        return sum;
    }

    long countSubarrays(int startIdx, int endIdx) {
        long n = endIdx - startIdx;
        return n * (n + 1) / 2;
    }

    int moveStartIdx(int start, int[] t) {
        for (;start < t.length; start++) {
            int num = t[start];
            this.counter[num]--;
            if (this.counter[num] == 0) {
                this.list.remove(this.list.indexOf(num));
                return start + 1;
            }
        }
        return start + 1;
    }
}

