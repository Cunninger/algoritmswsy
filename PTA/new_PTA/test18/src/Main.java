import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args){
         QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        String s = in.nextLine();
        String []s1 = s.split(":");
        int t1 = Integer.valueOf(s1[0]);
        if (t1>=0&&t1<12){
            out.println("Only "+ s+".  Too early to Dang.");
        }
        else{
            if (s1[1].equals("00")){
                for (int i = 0;i<t1-12;i++){
                    out.print("Dang");
                }

            }
            else{
                for (int i = 0;i<t1-12+1;i++){
                    out.print("Dang");
                }
            }
        }

        out.close();
        // 一定要关流;
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
