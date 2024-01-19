import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final int MAXN = 10000;
    private static long[] dp = new long[MAXN];
    private static long[] win = new long[MAXN];
    private static long[] lose = new long[MAXN];
    private static int[] use = new int[MAXN];
    private static int n, m;

    public static void main(String[] args) {
        QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        n = in.nextInt();
        m = in.nextInt();
        for(int i = 0; i < n; i++) {
            lose[i] = in.nextLong();
            win[i] = in.nextLong();
            use[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j >= use[i])
                    dp[j] = Math.max(dp[j] + lose[i], dp[j - use[i]] + win[i]);
                else
                    dp[j] += lose[i];
            }
        }
        out.println(dp[m] * 5);
        out.close();
    }
}

class  QuickInput
{
    BufferedReader buf;
    StringTokenizer tok;
    QuickInput(){
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    boolean hasNext(){
        while(tok == null || !tok.hasMoreElements()){
            try{
                tok = new StringTokenizer(buf.readLine());
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
    String next(){
        if(hasNext()) return tok.nextToken();
        return null;
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    BigInteger nextBigInteger(){
        return new BigInteger(next());
    }
    BigDecimal nextBigDecimal(){
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