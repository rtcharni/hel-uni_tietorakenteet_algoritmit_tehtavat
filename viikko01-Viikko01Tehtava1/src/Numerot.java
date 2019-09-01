public class Numerot {
    int summa(int x) {
        String numberString = String.valueOf(x);
        int total = 0;
        for (int i = 0; i < numberString.length(); i++) {
            total += Integer.parseInt(String.valueOf(numberString.charAt(i)));
        }
        return total;
    }
}
