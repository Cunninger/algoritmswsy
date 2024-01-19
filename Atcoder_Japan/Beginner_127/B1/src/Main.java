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
        int r = in.nextInt();
        int D = in.nextInt();
        int X2000 = in.nextInt();
        int X2001 = r*X2000-D;
        out.println(X2001);
        int X2002 = r*X2001-D;
        out.println(X2002);
        int X2003 = r*X2002-D;
        out.println(X2003);
        int X2004 = r*X2003-D;
        out.println(X2004);
        int X2005 = r*X2004-D;
        out.println(X2005);
        int X2006 = r*X2005-D;
        out.println(X2006);
        int X2007 = r*X2006-D;
        out.println(X2007);
        int X2008 = r*X2007-D;
        out.println(X2008);
        int X2009 = r*X2008-D;
        out.println(X2009);
        int X2010 = r*X2009-D;
        out.println(X2010);



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
