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
        long A = in.nextLong();
        long B = in.nextLong();
        long C = in.nextLong();
        long D = in.nextLong();

        HashSet<Long> cSet = new HashSet<>();
        HashSet<Long> dSet = new HashSet<>();
//        long res = 1;
//        long cnt = 1;
//        while (res < B) {
//            res = cnt * C;
//            cSet.add(res);
//            cnt++;
//        }
//        long res1 = 1;
//        long cnt1 = 1;
//        while (res1 < B) {
//            res1 = cnt * D;
//            dSet.add(res);
//            cnt1++;
//        }
        int ans = 0;
        for (long i = A; i <= B; i++) {
            if (i%C!=0 && i%D!=0){
                ans++;
            }
        }
        out.println(ans);

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
