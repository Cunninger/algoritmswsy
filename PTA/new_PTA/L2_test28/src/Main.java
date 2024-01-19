import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static class Qmd {
        double qmd;
        int info;

        public Qmd() {
        }

        public Qmd(double q, int i) {
            qmd = q;
            info = i;
        }

    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] store = new int[M][1000];
        int[] flagA = new int[N];// 记录哪行有A
        int[] flagB = new int[N];// 记录哪行有B
        int A = in.nextInt();
        int B = in.nextInt();
        for (int i = 0; i < M; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                store[i][j] = in.nextInt();
                if (store[i][j] == A) {
                    flagA[i] = i;
                }
                if (store[i][j] == B) {
                    flagB[i] = i;
                }

            }


        }

        Qmd[] qmdsA = new Qmd[N - 1];
        Qmd[] qmdsB = new Qmd[N - 1];

        // 计算所有人对A 的 亲密度
        for (int i = 0; i < flagA.length; i++) {
            for (int j = 0; j < store[flagA[i]].length; j++) {
                qmdsA[j] = new Qmd(1.0 / (store[flagA[i]].length), store[flagA[i]][j]);
            }
        }

        // 计算所有人对B 的 亲密度
        for (int i = 0; i < flagB.length; i++) {
            for (int j = 0; j < store[flagB[i]].length; j++) {
                qmdsB[j] = new Qmd(1.0 / (store[flagB[i]].length), store[flagB[i]][j]);
            }
        }

        // 遍历QmdA,QmdB,找出值最大的
        Arrays.sort(qmdsA, (o1, o2) -> (int) (o2.qmd - o1.qmd));


        Arrays.sort(qmdsB, (o1, o2) -> (int) (o2.qmd - o1.qmd));

        // 如果对A 来说B 就是最qmd的，那么输出原本
        if (qmdsA!=null && qmdsB!=null){
            if (qmdsA[0].info==B && qmdsB[0].info==A){
                out.println(A+" "+B);
            }
            else{
                out.println(A+" "+qmdsA[0]);
                out.println(B+" "+qmdsB[0]);

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
