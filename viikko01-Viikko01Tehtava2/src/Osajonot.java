public class Osajonot {
    int laske(String a, String b) {
//        if (a.length() < 1 || a.length() > 100 || b.length() < 1 || b.length() > 100) {
//            throw new Exception("kummassakin merkkijonossa pitää olla 1...100 merkkiä");
//        }
        int totalFound = 0;
        for (int i = 0; i < a.length(); i++) {
            int foundIndex = a.indexOf(b, i);
            if (foundIndex != -1) {
                totalFound++;
                i = foundIndex;
            } else {
                break;
            }
        }
        return totalFound;
    }
}
