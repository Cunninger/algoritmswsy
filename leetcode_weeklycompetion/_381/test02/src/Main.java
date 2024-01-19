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

        //in.nextInt().....
        //out.println().....
        String s = in.nextLine();
        out.println(minimumPushes(s));





        out.close();
        // 一定要关流;
    }

    public static int minimumPushes(String word) {
        if(word.length()<=8){
            return word.length();
        }
        int x = word.length()%8;
        int sum = 8;
        int y = word.length()/8;
        if (x==0){
            for (int i = 2;i<=y;i++){
                sum+=i*8;
            }
            return sum;
        }

        for (int i = 1;i<=y;i++){
            sum+=i*8;
        }
        sum+=x*(y+1);
        return sum;

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
