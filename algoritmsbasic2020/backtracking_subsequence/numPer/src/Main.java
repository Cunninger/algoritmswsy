import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static  PrintWriter out = new PrintWriter(System.out);
    static int[]arr;
    static boolean[]used;

    public static void main(String[] args){
         QuickInput in = new  QuickInput();

        //in.nextInt().....
        //out.println().....
        int N = in.nextInt();
        arr = new int[N];
        used = new boolean[N];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> path = new ArrayList<>();
        dfs(0,list,path);

        out.close();
        // 一定要关流;
    }

    private static void dfs(int i,List<Integer> list,List<List<Integer>>path) {
        if (i==arr.length){


            if (i != arr.length - 1) {
                out.println();
            }
            return;
        }

        for (int k = 0; k <arr.length ; k++) {
            if (!used[k]){
                used[k] = true;
                arr[i] = k+1;
                dfs(i+1);
                used[k] = false;
            }
        }



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
