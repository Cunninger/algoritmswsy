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
        char[] str = in.next().toCharArray();
//        int []cnt = new int[128];
//        for (int i = 0; i < str.length; i++) {
//            cnt[str[i]-'0']++;
//        }
//        for (int i = 0; i < str.length-1; i++) {
//            if (str[i]!=str[i+1]){
//                out.print(str[i]);
//                out.print(cnt[str[i]-'0']);
//            }
//        }
//        out.println(str[str.length-1]+""+cnt[str[str.length-1]-'0']);
        for (int i = 0; i < str.length; i++) {
            if (Character.isDigit(str[i])) {
                int k = i;
                int num = str[i] - '0';
                while (k + 1 < str.length && Character.isDigit(str[k + 1])) {
                    num = num * 10 + str[k + 1] - '0';
                    k++;
                }


                for (int j = 0; j < num - 1; j++) {
                    out.print(str[i - 1]);
                }

            } else {
                out.print(str[i]);
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
