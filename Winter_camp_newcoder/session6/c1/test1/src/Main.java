import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static boolean[]primeTable;
    static QuickInput in = new QuickInput();
    static PrintWriter out = new PrintWriter(System.out);


    public static void main(String[] args) {
        preTable((int)1e8);
        int q = in.nextInt();
        while (q-->0){
            int sum = 0;
            int l = in.nextInt();
            int r = in.nextInt();
            for(int i = l;i<=r;i++){
                if (primeTable[i])sum++;
            }
            out.println(sum);
        }
        out.close();


    }

    public static void preTable(int max){
        primeTable = new boolean[max+1];
        Arrays.fill(primeTable,true);
        primeTable[0] = primeTable[1] = false;
        for(int i = 2;i<=max/i;i++){
            if (primeTable[i]){
                for(int j=i*i;j<=max;j+=i){
                    primeTable[j] = false;
                }
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
