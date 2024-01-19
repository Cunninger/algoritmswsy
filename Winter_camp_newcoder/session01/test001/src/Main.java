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
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            String s = in.next();
            char[] str = s.toCharArray();
            boolean flag = true;
            for (int k = 0; k < str.length && flag; k++) {
                if (str[k] == 'D') {
                    for (int l = k+1; l < str.length && flag; l++) {
                        if (str[l] == 'F') {
                            for (int m = l+1; m < str.length && flag; m++) {
                                if (str[m] == 'S') {
                                    out.print(1 + " ");
                                    flag = false;
                                }
                            }
                        }
                    }
                }


            }
            if (flag){
                out.print(0+" ");
            }

            flag = true;
            for (int k = 0; k < str.length&&flag; k++) {
                if (str[k] == 'd') {
                    for (int l = k+1; l < str.length && flag; l++) {
                        if (str[l] == 'f') {
                            for (int m = l+1; m < str.length && flag; m++) {
                                if (str[m] == 's') {
                                    out.print(1 + " ");
                                    flag = false;
                                }
                            }
                        }
                    }
                }
            }
            if (flag){
                out.print(0);
            }
            out.println();
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
