import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Node {
    int x;
    int id;
    double force;
    List<Integer> ans;

    public Node() {
        this.x = 0;// x放大的倍数，
        this.force = 0;// 自身的功力
        this.id = 0;   // id自身的编号
        this.ans = new ArrayList<>();// 保存徒儿的下标
    }
}

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static final int MAXN = 100005;
    static Node[] per = new Node[MAXN];

    public static void bfs(int n, double r) {
        Queue<Node> q = new LinkedList<>();
        Node t1 = per[0];
        q.add(t1);
        double sum = 0;
        while (!q.isEmpty()) {
            t1 = q.poll();
            if (t1.x > 0) sum += t1.force;
            int len = t1.ans.size();
            for (int i = 0; i < len; ++i) {
                per[t1.ans.get(i)].force = t1.force * r;
                if (per[t1.ans.get(i)].x > 0) {
                    per[t1.ans.get(i)].force *= per[t1.ans.get(i)].x;
                }
                Node t2 = per[t1.ans.get(i)];
                q.add(t2);
            }
        }
        out.println((int) sum);
    }

    public static void main(String[] args) {
        QuickInput scanner = new QuickInput();


        int n = scanner.nextInt();
        double z = scanner.nextDouble();
        double r = scanner.nextDouble();
        r = (1.0 - r / 100.0);
        for (int i = 0; i < n; ++i) {
            per[i] = new Node();
            per[i].id = i;
            int k = scanner.nextInt();
            if (k == 0) {
                per[i].x = scanner.nextInt();
                continue;
            }
            for (int j = 0; j < k; ++j) {
                int stuid = scanner.nextInt();
                per[i].ans.add(stuid);
            }
        }
        per[0].force = z;
        if (per[0].x > 0) per[0].force *= per[0].x;
        bfs(n, r);

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