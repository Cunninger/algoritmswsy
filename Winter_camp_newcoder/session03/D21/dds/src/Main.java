import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int[] arr;

    public static void main(String[] args) {

        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int K = in.nextInt();

        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        if (K ==0){
            out.println(func1());

        }else {
            out.println(func2());
        }


        out.close();

    }

    public static long func1() {
        long maxSoFar = arr[0];
        long maxEnd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnd = Math.max(arr[i], maxEnd + arr[i]);
            maxSoFar = Math.max(maxEnd, maxSoFar);
        }
        return maxSoFar;
    }

    public static long func2() {

        long far = func1();
        for (int i =0; i < arr.length; i++) {
            if (i > 0) {
                swap(arr, i, i - 1);
                far = Math.max(func1(), far);
                swap(arr, i, i - 1);
            }
            if (i < arr.length - 1) {
                swap(arr, i, i + 1);
                far = Math.max(far, func1());
                swap(arr, i, i + 1);
            }
        }
        return far;
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
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
