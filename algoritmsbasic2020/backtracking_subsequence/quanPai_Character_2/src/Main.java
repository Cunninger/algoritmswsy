import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static char[]str;
    static boolean[]used;
    static LinkedList<String> path = new LinkedList<>();
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args){

         QuickInput in = new  QuickInput();

        str = in.nextLine().toCharArray();
        used = new boolean[str.length];
        dfs(0);
        //in.nextInt().....
        //out.println().....


        out.close();
        // 一定要关流;
    }

    private static void dfs(int i) {
        if (i==str.length){
            for (int j = 0; j < path.size(); j++) {
                out.printf("%5s",path.get(j));
            }
            out.println();
            return;
        }

        for (int j = 0; j < str.length; j++) {
            if (!used[j]){
                used[j] = true;
                path.add(String.valueOf(str[j]));
                dfs(i+1);
                used[j] = false;
                path.removeLast();
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
