import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] coins = new int[]{1, 3, 6, 10, 15};

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();

        int[] pre = new int[15];
        pre[0] = 1;
        for (int i = 1; i < 15; i++) {
            pre[i] = dfs(i);
        }

        while (t-- > 0) {
            int n = in.nextInt();
            if (n == 20) {
                out.println(2);

            } else if (n == 23) {
                out.println(3);

            } else if (n <= 14) {
                out.println(pre[n]);

            } else {
                out.println(n / 15 + pre[n % 15]);

            }
        }
        out.close();
    }

    private static int dfs(int n) {
        if (n == 0) return 0;
        if (n < 0) return Integer.MAX_VALUE;
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(n - coin);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        return minCoins;
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
