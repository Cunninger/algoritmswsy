import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        String name;
        int cnt;
        public Node(){

        }

        public Node(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    static int cc = 0;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);


        //in.nextInt().....
        //out.println().....

        int T = in.nextInt();
        Node[] node = new Node[T];
        for (int k = 0; k < T; k++) {
            HashSet<String> set = new HashSet<>();
            String[] s = in.nextLine().split(" ");
            for (int i = 1; i < s.length; i++) {
                set.add(s[i]);

            }
            node[k] = new Node();
            node[k].cnt = set.size();
            node[k].name = s[0];
        }

        Arrays.sort(node,(o1, o2) -> o2.cnt-o1.cnt);
//        int i = 0;
//        for (i = 0;i<3;i++){
//            if (i!=2){
//                out.print(node[i].name+" ");
//            }
//            else {
//                out.print(node[i].name);
//            }
//
//        }
        for (int i = 0; i < node.length; i++) {
            out.println(node[i].name+" "+node[i].cnt);
        }
        out.println();


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
