// 0-1背包

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] weight;
    static int[] values;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int capacity = in.nextInt();
        weight = new int[n];
        values = new int[n];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = in.nextInt();

        }
        for (int i = 0; i < values.length; i++) {
            values[i] = in.nextInt();

        }

        out.println(dp(0, capacity));


        out.close();

    }

    private static int dp(int i, int rest) {
        if (i == weight.length) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }

        int p1 = dp(i + 1, rest); // 不选择当前物品
        int p2 = -1;
        if (rest >= weight[i]) { // 当剩余容量足够时，考虑选择当前物品
            p2 = dp(i + 1, rest - weight[i]);
            if (p2 != -1) {
                p2 += values[i]; // 如果选择当前物品有效，加上当前物品的价值
            }
        }
        return Math.max(p1, p2);
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
