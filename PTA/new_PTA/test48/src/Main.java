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
        int Ra = in.nextInt();
        int Ca = in.nextInt();

        int [][]arr = new int[Ra][Ca];
        for (int i = 0;i<Ra;i++){
            for (int j = 0;j<Ca;j++){
                arr[i][j] = in.nextInt();
            }
        }

        int Rb = in.nextInt();
        int Cb = in.nextInt();

        int [][]brr = new int[Rb][Cb];
        for (int i = 0;i<Rb;i++){
            for (int j = 0;j<Cb;j++){
                brr[i][j] = in.nextInt();
            }
        }

        if (Ca != Rb) {
            out.println("Error: " + Ca + " != " + Rb);
        }
        else {
            out.println(Ra + " " + Cb);
            for (int i = 0; i < Ra; i++) {
                for (int j = 0; j < Cb; j++) {
                    int sum = 0;
                    for (int k = 0; k < Ca; k++) {
                        sum += arr[i][k] * brr[k][j];
                    }
                    out.print(sum);
                    if (j != Cb - 1) {
                        out.print(" ");
                    }
                }
                out.println();
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
