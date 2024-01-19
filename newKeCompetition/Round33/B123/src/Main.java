import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        QuickInput sc = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int k = sc.nextInt();

        int cnt = n * x / k;
        out.println(cnt);

        int[] arr = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            if (i * k % x == 0) {
                arr[i] = i * k / x;
            } else {
                arr[i] = i * k / x + 1;
            }
        }

        for (int i = 1; i <= cnt; i++) {
            out.print((arr[i] - arr[i - 1]) + " ");
        }
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