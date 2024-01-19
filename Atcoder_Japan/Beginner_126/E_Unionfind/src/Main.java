import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] father;
    static int[] size;
    static int[]stack;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        N = in.nextInt();
        M = in.nextInt();
        father = new int[N + 1];
        size = new int[N + 1];
        stack = new int[N+1];
        for (int i = 1; i <= N; i++) {
            father[i] = i;
            size[i] = 1;
        }
        for (int i = 0;i<M;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            merge(a,b);
        }
        int cnt = 0;
        for (int i = 1;i<=N;i++){
            if (father[i]==i){
                cnt++;
            }
        }
        out.println(cnt);
        out.close();

    }

    public static int find(int x) {
       int size = 0;
       while (x!=father[x]){
           size++;
           x = father[x];
       }
       while (size>0){
          father[stack[--size] ] = x;
       }

       return x;
    }

    public static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public static void merge(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            if (size[fx] > size[fy]) {
                father[fy] = fx;
                size[fx] += size[fy];
            } else {
                father[fx] = fy;
                size[fy] += size[fx];
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
