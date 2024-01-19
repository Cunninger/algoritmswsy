import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 2728; i<2732; i++) {
            String s = Integer.toString(i, 16);
            char[] str = s.toCharArray();
            if (str[0] != 0) {
                boolean flag = true;
                for (int j = 0; j < s.length(); j++) {
                    if (str[j] == 'a' || str[j] == 'b' || str[j] == 'c' || str[j] == 'd' || str[j] == 'e' || str[j] == 'f') {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    out.println(i);
//                    out.println(Integer.toString(i, 16).toUpperCase());
                    break;
                }

            }


        }out.close();

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
