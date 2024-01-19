import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static final int MOD = (int) 1e9+7;
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] arrN = new int[N+1];
        int[] arrM = new int[M+1];
        for (int i = 1; i <= N; i++) {
            arrN[i] = in.nextInt();

        }
        for (int i = 1; i <= M; i++) {
            arrM[i] = in.nextInt();
        }
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= M; i++) {
            dp[0][i] = 1;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arrN[i]==arrM[j]){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
                }
                dp[i][j]%=MOD;
                dp[i][j]+=MOD;
                dp[i][j]%=MOD;
            }

        }
        out.println(dp[N][M]%MOD);

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
