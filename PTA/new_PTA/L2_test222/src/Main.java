import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        String addr;
        int date;
        String nextAddr;

        public Node() {
        }

        public Node(String addr, int date, String nextAddr) {
            this.addr = addr;
            this.date = date;
            this.nextAddr = nextAddr;
        }
    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        String startAddr = in.next();
        int nodeCnt = in.nextInt();
        Node[] nodeArr = new Node[nodeCnt];
        HashMap<String, Node> map = new HashMap<>();
        for (int i = 0; i < nodeCnt; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].addr = in.next();
            nodeArr[i].date = in.nextInt();
            nodeArr[i].nextAddr = in.next();
            map.put(nodeArr[i].addr, nodeArr[i]);


        }

        List<Node> linkedList = new LinkedList<>();
        while (map.containsKey(startAddr)) {
            Node node = map.get(startAddr);
            linkedList.add(node);
            startAddr = node.nextAddr;
        }
        for (Node node : linkedList) {
            System.out.println(node.addr);
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
