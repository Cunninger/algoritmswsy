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
        int []arr = new int[n];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
            if (checkzhi(arr[i])||checkhe(arr[i])){
                cnt++;
            }
        }
        out.println(cnt);


        out.close();

    }
    public static boolean checkzhi(int a){
        if (a==0||a==1){
            return  false;
        }
        for (int i = 2; i*i <=a ; i++) {
            if (a%i==0){
                return false;
            }
        }

        return true;
    }

    public static boolean checkhe(int n) {
        if (n <= 1)
            return false;
        else if (n <= 3)
            return false;
        else if (n % 2 == 0 || n % 3 == 0)
            return true;
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0)
                return true;
            i += 6;
        }
        return false;
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
