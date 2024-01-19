import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static long fac[];
    static long inv[];
    static long n;
    static final int p = 1000_000_007;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        n = in.nextLong();
        long sum = 0;
        fac = new long[(int)n + 1];
        inv = new long[(int)n + 1];
        prepare();
        for (int i = 0; i <= n; i += 2) {
            sum = (sum + compute(n, i)) %p;
        }

        out.println(sum);


        out.close();

    }

    private static void prepare() {
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        inv[0] = inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            // inv[p%i]*(p/i)都是int类型，相乘可能爆int

            // 不直接开long []因为内存会超时
            inv[i] =  (p -  (p / i)*inv[p % i] % p);
        }


        inv[0] = 1;
        for (int i = 1; i <= n; i++) {
            inv[i] = inv[i] * inv[i - 1] % p;
        }


    }

    private static long compute(long n, long i) {
        if (n < i) {
            return 0;
        }
        return fac[(int) n] * inv[(int) i] % p * inv[(int) (n - i)]%p;

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
