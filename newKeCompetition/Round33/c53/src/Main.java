import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static char[] str;
    static int zero, one;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        str = in.next().toCharArray();
        int cnt = f();
        StringBuilder sb = new StringBuilder(String.valueOf(str));
        for (int i = 0; sb.length() > 1; i++) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
                zero--;
            } else if (sb.charAt(1) == '0') {
                sb.deleteCharAt(1);
                zero--;
            } else {
                sb.deleteCharAt(0);
                one--;
            }
            cnt = Math.max(one - zero, cnt);
        }
        out.println(cnt);

        out.close();

    }

    public static int f() {
        int cnt = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '0') {
                zero++;
            } else {
                one++;
            }

        }
        return Math.max(one - zero, 0);

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
