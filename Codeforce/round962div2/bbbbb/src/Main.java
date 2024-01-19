//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.*;
//
//public class Main{
//    public static void main(String[] args){
//         QuickInput in = new  QuickInput();
//        PrintWriter out = new PrintWriter(System.out);
//        int q = in.nextInt();
//        while (q-->0){
//            int n = in.nextInt();
//            int k = in.nextInt();
//            int cnt = 4*n-4;
//            if (k<=cnt){
//                out.println((k+1)/2);
//            }
//            else {
//                out.println(cnt/2+k-cnt);
//            }
//
//        }
//
//
//        out.close();
//
//    }
//}
//
//
//class  QuickInput
//{
//    BufferedReader buf;
//    StringTokenizer tok;
//     QuickInput(){
//        buf = new BufferedReader(new InputStreamReader(System.in));
//    }
//    boolean hasNext(){
//        while(tok == null || !tok.hasMoreElements()){
//            try{
//                tok = new StringTokenizer(buf.readLine());
//            }catch(Exception e){
//                return false;
//            }
//        }
//        return true;
//    }
//    String next(){
//        if(hasNext()) return tok.nextToken();
//        return null;
//    }
//    int nextInt(){
//        return Integer.parseInt(next());
//    }
//    long nextLong(){
//        return Long.parseLong(next());
//    }
//    double nextDouble(){
//        return Double.parseDouble(next());
//    }
//    BigInteger nextBigInteger(){
//        return new BigInteger(next());
//    }
//    BigDecimal nextBigDecimal(){
//        return new BigDecimal(next());
//    }
//    String nextLine() {
//        try {
//            return buf.readLine();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    private static final int MAXN = 10000;
    private static long[] dp;
    private static long[] win = new long[MAXN];
    private static long[] lose = new long[MAXN];
    private static int[] use = new int[MAXN];
    private static int n, m;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        n = in.nextInt();
        m = in.nextInt();
        dp = new long[m + 1]; // Adjust the size of dp array according to m
        Arrays.fill(dp, -1); // Initialize dp array with -1 to indicate uncalculated states
        for (int i = 0; i < n; i++) {
            lose[i] = in.nextLong();
            win[i] = in.nextLong();
            use[i] = in.nextInt();
        }
        out.println(memoization(m) * 5);
        out.close();
    }

    private static long memoization(int j) {
        if (j == 0) {
            return 0;
        }
        if (dp[j] != -1) {
            return dp[j];
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            if (j >= use[i]) {
                result = Math.max(result, memoization(j - use[i]) + win[i]);
            }
        }
        dp[j] = result + lose[n - 1]; // Assuming lose[n - 1] is the default loss for this state
        return dp[j];
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
    String nextLine() {
        try {
            return buf.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}
