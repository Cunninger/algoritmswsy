import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static boolean[] primeTable;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int l = in.nextInt();
        int r = in.nextInt();
        boolean flag = true;
        preparePrimeTable(100);
        for (int i = l; i <= r; i++) {
            if (check(i)) {
                flag = false;

                out.println(i);
                break;

            }
        }
        if (flag) out.println(-1);
        out.close();

    }

    private static boolean check(int i) {
        for (int j = 0; j < i; j++) {
            if (primeTable[j]) {
                for (int k = 0; k < i && k!=j; k++) {
                    if (primeTable[k]) {
                        for (int l = 0; l < i&& l!=k; l++) {
                            if (primeTable[l]) {
                                if (j * k * l == i) {
                                    return true;
                                }
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    public static void preparePrimeTable(int max) {
        primeTable = new boolean[max + 1];
        Arrays.fill(primeTable, true);
        primeTable[0] = primeTable[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (primeTable[i]) {
                for (int j = i * i; j <= max; j += i) {
                    primeTable[j] = false;
                }
            }
        }
    }
}
// 函数生成一个素数表，用于快速检查一个数是否是素数。


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
