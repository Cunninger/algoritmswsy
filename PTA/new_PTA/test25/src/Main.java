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
        String ss[] = s.split(" ",2);
        int a=0 ,b=0;
        if(isPositiveInteger(ss[0])){
             a = Integer.valueOf(ss[0]);
        }

        if(isPositiveInteger(ss[1])){
             b = Integer.valueOf(ss[1]);
        }

        if (a>=1 && a<=1000 && b>=1 && b<=1000){
            int c = a+b;
            out.println(a+" "+"+"+" "+b+" "+"="+" "+c);
        }
        else if ( !(a>=1 && a<=1000) && b>=1 && b<=1000){
            out.println("?"+" "+"+"+" "+b+" "+"="+" "+"?");
        }
        else if (a>=1 && a<=1000 && !(b>=1 && b<=1000)){
            out.println(a+" "+"+"+" "+"?"+" "+"="+" "+"?");
        }
        else{
            out.println("?"+" "+"+"+" "+"?"+" "+"="+" "+"?");
        }





        out.close();
        // 一定要关流;
    }

    public static boolean isPositiveInteger(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return str.charAt(0) != '0';
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
