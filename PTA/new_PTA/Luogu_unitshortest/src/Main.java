import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int MAXN = 10000;
    private static List<Edge>[] edges = new ArrayList[MAXN];
    private static int tot;

    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static void addEdge(int u, int v, int w) {
        if (edges[u] == null) {
            edges[u] = new ArrayList<>();
        }
        edges[u].add(new Edge(v, w));
        tot++;
    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            addEdge(a, b, w);
        }

        for (int x = 1; x <= n; x++) {
            out.println(x);
            if (edges[x] != null) {
                for (Edge edge : edges[x]) {
                    out.println(x + " " + edge.to + " " + edge.w);
                }
            }
            out.println();
        }

        out.close();
    }

    static class QuickInput {
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

        String nextLine() {
            try {
                return buf.readLine();
            } catch (Exception e) {
                return null;
            }
        }
    }
}
