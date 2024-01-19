import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int MAXN = 11; // 最大点数
    public static int MAXM = 21;// 最大边数

    public static int[] head = new int[MAXN];
    public static int[] next = new int[MAXM];
    public static int[] to = new int[MAXM];
    public static int[] weight = new int[MAXM];

    public static int cnt;


    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        build(6);
        addEdge(1,3,1);
        addEdge(1,5,1);
        addEdge(1,4,1);
        addEdge(4,2,1);
        addEdge(4,7,1);
        dfs(1);



        out.close();
        // 一定要关流;
    }

    public static void bfs(int start) {
        int[] visited = new int[MAXN];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println(u); // 打印访问的节点

            for (int i = head[u]; i != 0; i = next[i]) {
                int v = to[i];
                if (visited[v] == 0) {
                    visited[v] = 1;
                    queue.add(v);
                }
            }
        }
    }


    // dfs
    public static void dfs(int start) {
        int[] visited = new int[MAXN];
        dfsHelper(start, visited);
    }

    private static void dfsHelper(int node, int[] visited) {
        visited[node] = 1;
        System.out.println(node); // 打印访问的节点

        for (int i = head[node]; i != 0; i = next[i]) {
            int v = to[i];
            if (visited[v] == 0) {
                dfsHelper(v, visited);
            }
        }
    }


    public static void addEdge(int u,int v,int w){

        next[cnt] = head[u];
        to[cnt] = v;
        weight[cnt] = w;
        head[u] = cnt++;
    }

    public static void build(int n){
        cnt = 1;
        Arrays.fill(head,1,n+1,0);
    }

    // 有向图
    public static void directGraph(int [][]edges){
        for (int[]edge:edges){
            addEdge(edge[0],edge[1],edge[2]);
        }
    }

    // 无向图
    public static void undirectGraph(int [][]edges){
        for (int []edge:edges){
            addEdge(edge[0],edge[1],edge[2]);
            addEdge(edge[1],edge[0],edge[2]);
        }
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


