import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static Long[]Feb = new Long[50];
    static QuickInput in = new QuickInput();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {

        preFeb();
        int q = in.nextInt();
        while (q-- > 0) {
            solve();
        }
        out.close();

    }

    public static void preFeb() {
        Feb[0] = 0L;
        Feb[1] = 1L;
        for (int i = 2; i < 47; i++) {
            Feb[i] = Feb[i-1]+Feb[i-2];
        }
    }

    public static void solve() {
        long x;
        x = in.nextLong();
        Long[]ans = new Long[3];
        for (int i = 0; i <= 2; i++) {
            int it = Arrays.binarySearch(Feb, x);
            if (it < 0) {
                it = -it - 1;
                // 小于x的最大的数
                it--;
            }
            ans[i] = Feb[it];
            x -= Feb[it];
        }
        if (x != 0) out.println(-1);
        else out.println(ans[0] + " " + ans[1] + " " + ans[2]);
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
