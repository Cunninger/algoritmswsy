import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[25][25];
    static int[][] hr = new int[25][25];
    static int[][] xy = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1}, {0, 0}};

    public static void main(String[] args) {
        QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt(), m = in.nextInt();
        int x = in.nextInt(), y = in.nextInt();
        for (int i = 0; i < 9; i++) {
            int nx = x + xy[i][0];
            int ny = y + xy[i][1];
            if (nx >= 0 && nx <= n && ny >= 0 && ny <= m) {
                hr[nx][ny] = 1;
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (hr[i][j] != 1) {
                    if (i - 1 >= 0) dp[i][j] += dp[i - 1][j];
                    if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[n][m]);
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
