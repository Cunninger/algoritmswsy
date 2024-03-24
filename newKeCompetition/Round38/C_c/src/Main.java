import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        char[] str = new char[26];
        char[] ss = new char[(int) 1e5 + 1];
        for (int i = 0; i < 26; i++) {
            str[i] = (char) ('a' - 0 + i);

        }

        int n = in.nextInt();
        int k = in.nextInt();

        int uu = 0;
        for (int i = 0; i < n; i++) {
            ss[uu++] = str[i % 26];
        }
        int cc = 0;
        int a =
        for (int i = 1; i < 1000; i++) {
            if (i * (i - 1) == 2 * k) {
                cc = i;
                break;
            }
        }


        for (int i = 0; i < cc; i++) {
            ss[i] = 'o';
        }

        for (int i = 0; i < n; i++) {
            out.print(ss[i]);
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
