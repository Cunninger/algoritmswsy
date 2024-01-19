import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Node {
        int[] arr;

        public Node(int[] arr) {
            this.arr = arr;
        }
    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int q = in.nextInt();
        int col = in.nextInt();

        Node[] nodes = new Node[q];
        for (int i = 0; i < q; i++) {
            int[] arr = new int[col];
            for (int j = 0; j < col; j++) {
                arr[j] = in.nextInt();
            }
            nodes[i] = new Node(arr);
        }


        int cnt = 0;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = i + 1; j < nodes.length; j++) {

                int[] arr1 = nodes[i].arr;
                int[] arr2 = nodes[j].arr;
                if (check(arr1, arr2)) {
                    cnt++;
                }
            }
        }
        out.println(cnt);


        out.close();

    }

    private static boolean check(int[] arr1, int[] arr2) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += (arr1[i] - arr2[i]) * (arr1[i] - arr2[i]);
        }

        return isPerfectSquare(sum);
    }

    public static boolean isPerfectSquare(int num) {
        return Math.sqrt(num)== Math.floor(Math.sqrt(num));
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
