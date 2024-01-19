package newKeCompetition.test02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        // in.nextInt().....
        // out.println().....

        int n = in.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        int oddCnt = 0;//
        int oddSum = 0;//5
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                oddCnt++;
                oddSum += arr[i];
            }

        }
        int cnt = 0;
        int doubleSum = sum - oddSum;

        if (oddCnt % 2 == 0) {
            out.println(sum);
        } else {
            for (int i = arr.length-1; i >= 0; i--) {
                if (arr[i] % 2 != 0) {
                    doubleSum += arr[i];

                    if (cnt==oddCnt-1){
                        break;
                    }
                    cnt++;

                }


            }
            out.println(doubleSum);

        }


        out.close();
        // 一定要关流;
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
        if (hasNext())
            return tok.nextToken();
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
}
