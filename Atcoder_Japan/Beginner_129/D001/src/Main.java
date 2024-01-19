import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        int row = in.nextInt();
        int col = in.nextInt();
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = in.nextLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = 0;
                if (matrix[i][j] != '#') {
                    sum = 1;
                    for (int k = 0; k < 4; k++) {
                        int x = i;
                        int y = j;
                        while (true) {
                            x += dx[k];
                            y += dy[k];
                            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] != '#') {
                                sum++;
                            } else {
                                break;
                            }


                        }
                    }
                }
                ans = Math.max(sum, ans);
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
