public class Halkaisu {
    int laske(int[] t) {
        int totalVariation = 0;
        int left = t[0];
        int right = 0;

        for (int i = 1; i < t.length; i++) {
            right += t[i];
        }

        for (int i = 1; i < t.length; i++) {
            if (left == right) {
                totalVariation++;
            }
            left += t[i];
            right -= t[i];
        }

        return totalVariation;
    }

    int firstWay(int[] t) {
        int totalVariation = 0;

        int left = t[0];

        for (int i = 1; i < t.length; i++) {

            int right = 0;
            for (int j = i; j < t.length; j++) {
                right += t[j];
            }

            if (left == right) {
                totalVariation++;
            }
            left += t[i];

        }
        return totalVariation;
    }
}
