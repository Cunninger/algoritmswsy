import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int[] spilt(int v) {
        int[] res = new int[]{0, 0};
        while (v % 2 == 0) {
            v /= 2;
            res[0]++;
        }
        while (v % 5 == 0) {
            v /= 5;
            res[1]++;
        }
        return res;
    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];
        int all = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        long[][] opt = new long[14][31];
        for (int i = 0; i < n; i++) {
            int[] xx = spilt(arr[i]);
            opt[xx[0]][xx[1]]++;
        }
        long ans1 = 0;
        long ans2 = 0;
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 31; j++) {
                for (int k = 0; k < 14; k++) {
                    for (int l = 0; l < 31; l++) {
                        if (i + k < 2 || j + l < 2)
                            continue;
                        if (i == k && j == l) {
                            ans1 += opt[i][j] * (opt[i][j] - 1) / 2;
                        } else {
                            ans2 += opt[i][j] * opt[k][l];
                        }
                    }
                }
            }
        }
        out.println(ans1 + ans2 / 2);

        out.println();

        out.close();

    }

    private static int compute(long res) {
        String s = String.valueOf(res);
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
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
