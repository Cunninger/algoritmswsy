import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int M = in.nextInt();
        int C = in.nextInt();
        int[][] map = new int[N + 1][M + 1];
        int[][] pref = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = in.nextInt();
                pref[i][j] = pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1] + map[i][j];
            }
        }


        int maxSum = Integer.MIN_VALUE;
        int x = 0, y = 0;
        for (int i = C; i <= N; i++) {
            for (int j = C; j <= M; j++) {
                int tempSum = pref[i][j] - pref[i - C][j] - pref[i][j - C] + pref[i - C][j - C];
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                    x = i - C + 1;
                    y = j - C + 1;
                }
            }
        }

        out.println(x + " " + y);
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
