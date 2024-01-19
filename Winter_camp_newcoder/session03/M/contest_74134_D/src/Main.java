import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static char[] str;
    static int[][] dp;
    static final int mod = (int)1e9+7;
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        str = in.nextLine().toCharArray();
        int N = str.length;
        dp = new int[N + 1][9];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int t = str[i - 1] - '0';
            for (int j = 0; j <= 8; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] = (dp[i][j] + dp[i - 1][(j - t + 9) % 9]) % mod;
            }
        }
        out.println((dp[N][0]-1)%mod);


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
