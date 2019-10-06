
public class Laskulauseke {
    public long laske(String s) {
        long res = calculate(s);
        return res;
    }


    public static long calculate(String s) {
        return new Object() {
            int pos = -1, ch;
            void nextChar() {
                ch = (++pos < s.length()) ? s.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            long parse() {
                nextChar();
                long x = parseExpression();
                if (pos < s.length());
                return x;
            }

            long parseExpression() {
                long x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm();
                    else return x;
                }
            }

            long parseTerm() {
                long x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor();
                    else return x;
                }
            }

            long parseFactor() {
                if (eat('+')) return parseFactor();
                long x = 0;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Long.parseLong(s.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = s.substring(startPos, this.pos);
                    x = parseFactor();
                }
                return x;
            }
        }.parse();
    }
}
