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
        int T = in.nextInt();
        int sum = 0;
        char[][]str = new char[2][T];
        for (int i = 0;i<2;i++){
            str[i] = in.nextLine().toCharArray();
        }

        for (int k = 0;k<T;k++){
        if (str[0][k]=='Y' &&str[1][k]=='Y' ){
            sum+=3;
        }
        else if (str[0][k]=='Y' &&str[1][k]=='N' ){
            sum+=2;
        }
        else if (str[0][k]=='N' &&str[1][k]=='N'){
            sum+=0;
        }
        else {
            sum+=2;
        }
    }

        out.println(sum);

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
