package newKeCompetition.JIMEI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class problem_E {
    public static void main(String[] args){
        QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        //in.nextInt().....
        //out.println().....
        int T = in.nextInt();
        while (T-->0){
            int n = in.nextInt();// mu
            int m = in.nextInt();
            // 先做铲子
            int n1 = n;
            int m1 = m;

            int n2 = n;
            int m2 = m;
            n1-=2;
            m1-=1;
            int chan = 0;
            while (n1>=0 && m1>=0){
                chan++;
                if (m1==2&& n1==1){
                    chan++;
                    break;
                }
                n1-=2;
                m1-=1;



            }

            n2-=1;
            m2-=2;
            int jian = 0;
            while (n2>=0 && m2>=0){
                jian++;
                if (m2==1&& n2==2){
                    jian++;
                    break;
                }
                n2-=1;
                m2-=2;

            }
            if (m2==1&& n2==2){
                jian++;
            }
            out.println(Math.max(chan,jian));
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
