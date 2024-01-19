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
        int q = in.nextInt();
        int[]arr = new int[n+1];
        for (int i = 1;i<=n;i++){
            arr[i] = in.nextInt();
        }
        while(q-->0){
            boolean flag = true;
            int l = in.nextInt();
            int r = in.nextInt();
            for (int i = l;i<=r && flag;i++){
                for (int j = l+1;j<=r&&flag && i!=j;j++){
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
                    if (Math.abs(arr[i]-arr[j])<=365){
                        out.println("YES");
                        flag =false;
                        break;

                    }
                }
            }

            if (flag){
                out.println("NO");
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
