import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Node {
        int count;
        int number;

        public Node(int c, int n) {
            count = c;
            number = n;
        }
    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            q.add(in.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int cnt = in.nextInt();
            int num = in.nextInt();
            list.add(new Node(cnt, num));

        }
        list.sort((Node a, Node b) -> (b.number - a.number));

        for (Node c : list) {
            while (c.count > 0) {
                int x = q.peek();
                if (x >= c.number) {
                    break;
                }
                // 下面是x<c.number
                int z = q.poll();
                q.add(c.number);
                c.count--;


            }
        }
        long sum = 0;
        while (!q.isEmpty()){
            sum+=q.poll();
        }
        out.println(sum);

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
