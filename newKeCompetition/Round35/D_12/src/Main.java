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
        int[]arr = new int[n+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int cnt = 0;
        int [][]memo = new int[n+1][2];
        List<Integer>[] mm = new List[n+1];
        for (int i = 0; i < mm.length; i++) {
            mm[i] = new ArrayList<>();
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]!=i){
                cnt++;
//                memo[i][0] = arr[i];
//                memo[i][1] = i;
                mm[i].add(i);
                mm[i].add(i);
            }
        }
        out.println(cnt);
        for (int i = 1; i < mm.length; i++) {
            if (mm[i].size()!=0){
                out.println(mm[i].get(0)+" "+mm[i].get(1));
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
