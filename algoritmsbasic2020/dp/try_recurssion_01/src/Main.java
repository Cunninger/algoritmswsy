
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static char[] str;
    static PrintWriter out = new PrintWriter(System.out);

    /**
     * 打印一个字符串的全部子序列
     */

    public static void main(String[] args) {
        QuickInput in = new QuickInput();

        String s = in.nextLine();
        str = s.toCharArray();
        String path = "";
        dfs(0, path);


        out.close();

    }

    private static void dfs(int index, String path) {
        if (index == str.length) {
            out.println(path);
            return;
        }

        dfs(index + 1, path);
        dfs(index + 1, path + String.valueOf(str[index]));

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
