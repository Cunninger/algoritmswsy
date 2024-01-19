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
        int q = in.nextInt();
        while (q-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int mx = Integer.MIN_VALUE;
            int mn = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
                mx = Math.max(mx, arr[i]);
                mn = Math.min(mn, arr[i]);
            }
            if (arr[0] <= mn || arr[arr.length - 1] >= mx) {
                out.println("YES");
            } else {
                out.println("NO");
            }


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
