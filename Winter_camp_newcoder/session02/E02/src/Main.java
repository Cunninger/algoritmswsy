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
        int T = in.nextInt(); // 读取测试用例数目
        while (T-- > 0) {
            int n = in.nextInt(); // 读取宝石数量
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = in.nextInt(); // 读取每个宝石的颜色
            }
            int cnt = 0;
            int ans = 0;
            boolean one = false;
            boolean zero = false;
            for (int i = n - 1; i >= 0; i--) {
                cnt++;
                if (col[i] == 1) {
                    one = true;
                } else {
                    zero = true;
                }

                if (one && zero) {
                    ans++;
                    cnt=0;
                    one = false;
                    zero = false;
                }


            }
            if (zero||one){
                ans +=cnt;
            }
            out.println(ans);


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
