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
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        int res = Integer.MAX_VALUE;
        int idx = 0;
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            int index = Arrays.binarySearch(a, b[i]);
            if (index < 0) {
                index = -index - 1;
            } else {
                index++;
            }
            if (index != 0) {
                if (res > Math.abs(b[i] - a[index - 1])) {
                    res = Math.abs(b[i] - a[index - 1]);
                    idx = index - 1;
                    j = i;
                }

            }
            if (index != n) {
                if (res > Math.abs(b[i] - a[index])) {
                    res = Math.abs(b[i] - a[index]);
                    idx = index;
                    j = i;
                }
            }

        }
        int temp = a[idx];
        a[idx] = a[j];
        a[j] = temp;
        for (int i = 0; i < a.length; i++) {
            out.println(a[i]);
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
