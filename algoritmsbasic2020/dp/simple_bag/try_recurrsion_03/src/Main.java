
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

// 打印一个字符串的全部排列
public class Main {
    static char[] str;
    static boolean[] flag;
    static List<String> path = new ArrayList<>();
    static HashSet<List<String>> res = new HashSet<>();

    public static void main(String[] args) {

        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        String s = in.nextLine();
        str = s.toCharArray();
        flag = new boolean[str.length];
        dfs();
        for (var c : res) {
            for (var cc : c) {
                out.print(cc + " ");
            }
            out.println();
        }


        out.close();

    }

    private static void dfs() {

        if (path.size() == str.length) {
            res.add(new ArrayList<>(path));// 收集结果
            return;
        }
        // 遍历每一个位置
        for (int i = 0; i < str.length; i++) {

            if (!flag[i]) {
                flag[i] = true;     // 标记使用-->怎么体现标记使用
                path.add(String.valueOf(str[i]));
                dfs();
                // 回溯
                flag[i] = false;    // 标记未使用-->怎么体现未使用呢
                path.remove(path.size() - 1);

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
