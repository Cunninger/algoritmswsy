import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static  PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        QuickInput scanner = new  QuickInput();

        // a[x] 表示指数是x, a[x] 表示系数
        int n = scanner.nextInt();
        double[] a = new double[100010];
        int index1 = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            a[x] = scanner.nextDouble();
            if (x > index1) {
                index1 = x;
            }
        }

        int m = scanner.nextInt();
        double[] b = new double[100010];
        int index2 = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            int x = scanner.nextInt();
            b[x] = scanner.nextDouble();
            if (x > index2) {
                index2 = x;
            }
        }

        int temp = index1 - index2;
        double[] c = new double[100010];

        while (index1 - index2 >= 0) {
            double q = a[index1] / b[index2];
            c[index1 - index2] = q;
            for (int i = index1, j = index2; i >= 0 && j >= 0; i--, j--) {
                a[i] -= b[j] * q;
            }
            while (a[index1] == 0) {
                index1--;
            }
        }

        fun(c, temp);
        out.println();
        fun(a, index1);
        out.close();
    }

    public static void fun(double[] arr, int x) {
        int num = 0;
        for (int i = 0; i <= x; i++) {
            if (Math.abs(arr[i]) + 0.05 >= 0.1) {
                num++;
            }
        }
        out.print(num);
        if (num == 0) {
            out.print(" 0 0.0");
        }
        for (int i = x; i >= 0; i--) {
            if (Math.abs(arr[i]) + 0.05 >= 0.1) {
                out.printf(" %d %.1f", i, arr[i]);
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