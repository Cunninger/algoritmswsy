import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();

        }
        long mmax = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                long sum = 0;
                for (int l = i; l < j; l++) {
                    sum += arr[l];
                }
                if (sum > mmax) {
                    mmax = sum;
                    maxStart = i;
                    maxEnd = j - 1;
                }
            }

        }
        if (k == 0) {
            out.println(mmax);

        }
        int p1= 0;
        if (k == 1) {
            if (maxStart-1>=0 &&arr[maxStart-2]>arr[maxStart-1]){
                p1 = Math.max(arr[maxStart-2],p1);
            }
            if (maxEnd+1<arr.length && arr[maxEnd+2]>arr[maxEnd+1]){
               p1 = Math.max(p1,arr[maxEnd+2]);
            }

            out.println(mmax+p1);
        }


        out.close();

    }
}


class QuickInput {
    BufferedReader buf;
    StringTokenizer tok;

    QuickInput() {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }

    boolean hasNext() {
        while (tok == null || !tok.hasMoreElements()) {
            try {
                tok = new StringTokenizer(buf.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    String next() {
        if (hasNext()) return tok.nextToken();
        return null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    BigDecimal nextBigDecimal() {
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
