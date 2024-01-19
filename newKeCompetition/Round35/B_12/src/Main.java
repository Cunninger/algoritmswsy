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
        int[]arr = new int[2*n];
//        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();

        }
        Arrays.sort(arr);
        int[]arr1 = new int[n];
        int[]arr2 = new int[n];
        int t = 0;
        int x =0;
        for (int i = 0; i < arr.length; i++) {
                if(i%2==0){
                    arr1[t++] = arr[i];
                }
                else {
                    arr2[x++] = arr[i];
                }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1+=arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            sum2+=arr2[i];
        }
        if (sum1!=sum2){
            out.println(-1);
        }
        else {
            for (int i = 0; i < arr1.length; i++) {
                out.print(arr1[i]+" ");
            }
            out.println();

            for (int i = 0; i < arr1.length; i++) {
                out.print(arr2[i]+" ");
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
