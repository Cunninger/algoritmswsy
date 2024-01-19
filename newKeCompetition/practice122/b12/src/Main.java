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
        int T = in.nextInt();

        while (T-->0){
            int n = in.nextInt();
            int []a = new int[n];
            int []b = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();


            }
            for (int i = 0; i < b.length; i++) {
                b[i] = in.nextInt();
            }

            boolean flag = true;
            for (int i = 0; i < a.length; i++) {
                if (!map.containsKey(a[i])){
                    map.put(a[i],b[i]);
                }
                else {
                    if (map.get(a[i])!=b[i]){
                        out.println("No");
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                out.println("Yes");
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
