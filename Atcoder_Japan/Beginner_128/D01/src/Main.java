import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * 考察动态规划
 */
public class Main {
    static final int inf = 1000_000_000+7;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = in.nextInt();
        }
        int[][] dpL = new int[N + 1][K + 1];
        int[][] dpR = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dpL[i], -inf);
            Arrays.fill(dpR[i], -inf);

        }
        dpL[0][0] = 0;
        for (int i = 0; i <  N; i++) {
            for (int j = 0; j < K; j++) {
                dpL[i + 1][j + 1] = Math.max(dpL[i + 1][j + 1], dpL[i][j] + value[i]);
                if (j + 2 <= K) {
                    dpL[i + 1][j + 2] = Math.max(dpL[i + 1][j + 2], dpL[i][j]);
                }
            }


        }
        dpR[N][0] = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < K; j++) {
                dpR[i][j + 1] = Math.max(dpR[i][j + 1], dpR[i + 1][j] + value[i]);
                if (j +2 <= K) {
                    dpR[i][j + 2] = Math.max(dpR[i][j + 2], dpR[i + 1][j]);
                }
            }
        }
//        out.println("矩阵dpL");
//        for (int i = 0; i < dpL.length; i++) {
//            for (int j = 0; j < dpL[0].length; j++) {
//                out.printf("%-15d",dpL[i][j]);
//            }
//            out.println();
//        }
//
//        out.println("矩阵dpR");
//        for (int i = 0; i < dpR.length; i++) {
//            for (int j = 0; j < dpR[0].length; j++) {
//                out.printf("%-15d",dpR[i][j]);
//            }
//            out.println();
//        }
        int ans = -inf;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                for (int l = i; l <= N; l++) {
                    for (int m = 0; m <= K - j; m++) {
                        ans = Math.max(dpL[i][j]+ dpR[l][m],ans);
                    }

                }

            }

        }
        out.println(ans);


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
