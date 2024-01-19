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
        Map<Integer,Integer> map = new TreeMap<>(Comparator.reverseOrder());

        int T  = in.nextInt();
        while (T-->0){
            int t = in.nextInt();
            int[] a = new int[t];
            for (int i = 0; i < t; i++) {
                a[i] = in.nextInt();
                map.put(a[i],map.getOrDefault(a[i],0)+1);
            }

        }
        int max = 0;
        int ans = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue() > max) {
                    max = entry.getValue();
                    ans = entry.getKey();

            }
        }
        out.println(ans+" "+max);

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
