import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        //in.nextInt().....
        //out.println().....
        String[] str = in.nextLine().split(" ");
        TreeSet<String> tree = new TreeSet<>();
        HashSet<String> set = new HashSet<>();
        for (String s : str) {
            set.add(s);
        }
        int sum = 0;
        int t = in.nextInt();
        String[][] mat = new String[t][2];
        for (int i = 0; i < mat.length; i++) {
            mat[i][0] = in.next();
            mat[i][1] = in.next();
            int temp = Integer.parseInt(mat[i][1]);
            sum += temp;
        }
        double avg = (double) sum / t;
        boolean flag = true;
        for (int i = 0; i < mat.length; i++) {
            if (Integer.parseInt(mat[i][1]) > avg && (!set.contains(mat[i][0]))) {
                tree.add(mat[i][0]);
                flag = false;
            }
        }

        if (flag) {
            out.println("Bing Mei You");
        } else {
            for (String s : tree) {
                out.println(s);
            }
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
