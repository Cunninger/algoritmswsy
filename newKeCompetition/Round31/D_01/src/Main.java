import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        HashSet<String> set = new HashSet<>();
        int n = in.nextInt();
        while (n-- > 0) {
            int op = in.nextInt();
            String x = String.valueOf(in.nextInt());
            String y = String.valueOf(in.nextInt());
            if (op == 1 && !y.equals( "0")) {
                if (!set.contains(x) && !set.contains(y)) {

                    int index = sb.indexOf(y);
                    sb.insert(index, x);
                } else if (!set.contains(x) && set.contains(y)) {
                    int index = sb.indexOf(y);
                    sb.insert(index, x);
                } else if (set.contains(x) && !set.contains(y)) {
                    int index = sb.indexOf(x);
                    sb.insert(index - 1, y);
                }

            } else if (op == 1 && y.equals( "0")) {
                sb.insert(0, x);
            } else if (op == 2) {
                sb.deleteCharAt(sb.charAt(0));
            }

            set.add(String.valueOf(x));
            set.add(String.valueOf(y));

        }
        out.println(sb.length());
        char[] str = sb.toString().toCharArray();
        for (int i = 0; i < sb.length(); i++) {
            out.println(str[i] + " ");
        }


        out.close();

    }
}


class QuickInput {
    BufferedReader buf;
    StringTokenizer tok;

    QuickInput() {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }

    boolean hasNext() {
        while (tok == null || !tok.hasMoreElements()) {
            try {
                tok = new StringTokenizer(buf.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    String next() {
        if (hasNext()) return tok.nextToken();
        return null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    BigDecimal nextBigDecimal() {
        return new BigDecimal(next());
    }

    String nextLine() {
        try {
            return buf.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}
