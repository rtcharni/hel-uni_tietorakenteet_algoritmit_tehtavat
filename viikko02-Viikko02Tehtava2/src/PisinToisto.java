public class PisinToisto {
    int laske(int[] t) {
        int maxTotal = 1;

        int onGoing = 0;
        int onGoingTotal = 1;

        for (int i = 0; i < t.length; i++) {
            if (t[i] == onGoing) {
                onGoingTotal++;

                if (onGoingTotal > maxTotal) {
                    maxTotal = onGoingTotal;
                }

            } else {
                onGoing = t[i];
                onGoingTotal = 1;
            }
        }
        return maxTotal;
    }
}
