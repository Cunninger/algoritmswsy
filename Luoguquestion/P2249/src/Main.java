//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.*;
//
//public class Main {
//    static int[]arr = new int[1000005];
//    public static int binsearch(int x){
//        int l =1,r = arr.length;
//        while (l<r){
//            int mid = (l+r-1)>>1;
//            if (arr[mid]>=x){
//                r = mid;
//            }
//            else l = mid+1;
//        }
//        if (arr[l]==x)return l;
//        else return -1;
//
//    }
//
//    public static void main(String[] args) {
//        QuickInput in = new QuickInput();
//        PrintWriter out = new PrintWriter(System.out);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        for (int i = 1; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }
//
//        while (m-- > 0) {
//            int idx = 0;
//            int a = in.nextInt();
//            idx = binsearch(a);
//            out.print(idx+" ");
//        }
//
//        out.close();
//
//    }
//}
//
//
//class QuickInput {
//    BufferedReader buf;
//    StringTokenizer tok;
//
//    QuickInput() {
//        buf = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    boolean hasNext() {
//        while (tok == null || !tok.hasMoreElements()) {
//            try {
//                tok = new StringTokenizer(buf.readLine());
//            } catch (Exception e) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    String next() {
//        if (hasNext()) return tok.nextToken();
//        return null;
//    }
//
//    int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    long nextLong() {
//        return Long.parseLong(next());
//    }
//
//    double nextDouble() {
//        return Double.parseDouble(next());
//    }
//
//    BigInteger nextBigInteger() {
//        return new BigInteger(next());
//    }
//
//    BigDecimal nextBigDecimal() {
//        return new BigDecimal(next());
//    }
//
//    String nextLine() {
//        try {
//            return buf.readLine();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long l=in.nextLong();
        long r=in.nextLong();
        long cnt=0;
        long x=l;
        while(x<=r){
           // boolean falg=false;
            out:
            for(long y=(long)Math.pow(x,0.5);y<=r*r;y++){
                for(long z=0;z<=y;z++){
                    if(x==y*y-z*z){
                        System.out.println(x+" "+y+" "+z);
                       // falg=true;
                        cnt++;
                        break out;
                    }
                }
            }

            x++;

        }
        System.out.println(cnt);
    }
}
