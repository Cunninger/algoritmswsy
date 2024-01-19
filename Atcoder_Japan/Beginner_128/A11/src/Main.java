/**
 * 其实是      B     题
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Node {
        int id;
        String name;
        int score;

        public Node(int i,String n, int s) {
            id = i;
            name = n;
            score = s;
        }
    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt();

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = in.next();
            int score = in.nextInt();
            list.add(new Node(i+1,name, score));

        }

        list.sort((Node a, Node b) -> (a.name.compareTo(b.name) == 0 ? b.score - a.score : a.name.compareTo(b.name)));
        for (Node c:list){
            out.println(c.id);
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
