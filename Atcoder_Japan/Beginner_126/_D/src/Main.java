import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Node {
    int to, weight;
    Node next;

    public Node(int t, int w, Node n) {
        to = t;
        weight = w;
        next = n;
    }
}

public class Main {

    static final int MAXN = 100005;
    static Node[] edges = new Node[MAXN];
    static boolean[] flag = new boolean[MAXN];
    static int[] color = new int[MAXN];

    public static void main(String[] agrs) {
        Q in = new Q();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        for (int i = 0; i < N - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            add(x, y, z);
            add(y, x, z);
        }

        dfs(1);
        for (int i = 1;i<=N;i++){
            out.println(color[i]);
        }
        out.close();
    }

    private static void dfs(int i) {
        flag[i] = true;
        for (Node j = edges[i]; j != null; j = j.next) {
            int u = j.to;
            if (flag[u]) {
                continue;
            }
            if (j.weight % 2 == 0) {
                color[u] = color[i];
                dfs(u);

            } else {
                color[u] = 1 - color[i];
                dfs(u);
            }
        }
    }

    public static void add(int x, int y, int z) {
        edges[x] = new Node(y, z, edges[x]);
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
}