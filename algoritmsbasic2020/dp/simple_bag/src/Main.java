import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int maxSum = 0;
    static int[] weight;
    static int[]value;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        //in.nextInt().....
        //out.println().....
        int N = in.nextInt();
        int W = in.nextInt();
         weight = new int[N];
         value = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        out.println(dp(0,  W));
        out.println(dp2(0,  W));

        out.close();
        // 一定要关流;
    }

    private static int dp(int index, int rest) {
        if (rest<0){
            return -1;
        }
        //rest >=0
        // index 表示index之后
        if (index == weight.length) {
            return 0;
        }
        int p1 = dp(index+1,rest);

        int p2 = -1;
        int p2Next = dp(index+1,rest-weight[index]);
        if (p2Next!=-1){
            p2 = p2Next+value[index];
        }
        return Math.max(p1,p2);

    }
    private static int dp2(int index, int rest) {
        if (rest<0){
            return -1;
        }
        if (rest==0){
            return 0;
        }

        if (index == weight.length) {
            return -1;
        }
        int p1 = dp2(index+1,rest);

        int p2 = -1;
        int p2Next = dp2(index+1,rest-weight[index]);
        if (p2Next!=-1){
            p2 = p2Next+value[index];
        }
        return Math.max(p1,p2);

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
