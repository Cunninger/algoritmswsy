import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args){
        QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int x = in.nextInt();
        int win = 0;
        int lose = 0;
        boolean flag = true;
        for (int i = 0; i < n && flag; i++) {
            for (int j = 0; j < n&& flag; j++) {
                if (i+j==n){
                    if (x>=0 && x==i-j){
                        out.println(i+" "+j);
                    }
                    else if (x<0 && j-i==x){
                        out.println(i+" "+j);
                    }
                    else if (x==0){
                        flag = false;
                        out.println("-1");
                        break;
                    }
                }
            }
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
