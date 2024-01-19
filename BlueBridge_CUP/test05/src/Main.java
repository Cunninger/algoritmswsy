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
        int N = sc.nextInt();
        int[] A = new int[N+1];
        int[] B = new int[N+1];
        int[] P = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = sc.nextInt();
        }
        for(int i=1; i<=N; i++) {
            B[i] = sc.nextInt();
            P[B[i]] =i;
        }
        long ans = 0;
        for(int i=1; i<=N; i++) {
            for(int j=i+1; j<=N ; j++) {
                if(P[A[i]] < P[A[j]]) {
                    ans += j - i;
                }
            }
        }
        out.print(ans);
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