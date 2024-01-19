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
        String s = in.next();
       s= s.substring(2,s.length());
        String wl = in.next();

        int a =Integer.parseInt(s);
        int win = (a/2)+1;
        int redwin = 0;
        int purwin = 0;
        for (int i = 0; i < wl.length(); i++) {
            if (wl.charAt(i)=='R')redwin++;
            else purwin++;
            if (redwin==win){
                out.println("kou!");
                out.println(i+1);
                break;
            }
            else if (purwin==win){
                out.println("yukari!");
                out.println(i+1);
                break;
            }

        }
        if (redwin!=win && purwin!=win){
            out.println("to be continued.");
            out.println(wl.length());
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
