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
        int N = in.nextInt();
        int[] v = new int[N];
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < v.length; i++) {
            v[i] = in.nextInt();
            pq.add((double) v[i]);
        }
        while (pq.size() > 1) {
            double a = pq.poll();
            double b = pq.poll();
            pq.add((a + b) / 2);
        }
        if(pq.size()==1){
            out.printf("%.7f", pq.poll());
            out.close();
            return;
        }
        else {
            double res = pq.poll();
            double next = pq.poll();
            out.printf("%.7f", (res + next) / 2.0);
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
