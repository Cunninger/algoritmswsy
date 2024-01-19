import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 60;

    public static void main(String[] args) {
        Q in = new Q();
        PrintWriter out = new PrintWriter(System.out);
        long input = in.nextLong();
        long miao = input / 1000;
        long h = (miao / 3600) % 24;
        miao %= 3600;
        long min = miao / 60;
        miao %= 60;
        out.printf("%02d:%02d:%02d", h, min, miao);
        out.close();

    }


}

class Q {
    BufferedReader buf;
    StringTokenizer tok;

    Q() {
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
        if (hasNext()) {
            return tok.nextToken();

        }
        return null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}