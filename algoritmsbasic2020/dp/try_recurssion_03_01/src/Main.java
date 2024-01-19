//打印一个字符串的全部排列（不存）


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static boolean[] flag;
    static char[] str;
    static List<String> path = new ArrayList<>();
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        QuickInput in = new QuickInput();

        String s = in.nextLine();
        str = s.toCharArray();
        flag = new boolean[str.length];
        dfs();


        out.close();

    }

    private static void dfs() {
        if (path.size()==str.length){
            for (var I:path){
                out.print(I+" ");
            }
            out.println();
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (!flag[i]){
                flag[i] = true;
                path.add(String.valueOf(str[i]));
                dfs();
                // 回溯
                flag[i] = false;
                path.remove(path.size()-1);
            }
        }
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
