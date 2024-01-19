import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Node {
        int loc;
        int num;

        public Node(int loc, int num) {
            this.loc = loc;
            this.num = num;
        }
    }

    public static void main(String[] args) {

        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        Node[] arr = new Node[n + 1];
        int k = n;
        List<Integer>[] mm = new List[n + 1];
        for (int i = 0; i < mm.length; i++) {
            mm[i] = new ArrayList<>();
        }
        HashSet<Integer> b = new HashSet<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int i = 1; i < arr.length; i++) {
            int aa = in.nextInt();
            arr[i] = new Node(i, aa);
            b.add(aa);
//            map.put(arr[i].num, map.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr, 1, n + 1, (o1, o2) -> o1.num - o2.num);
        int cnt = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i =1 ; i <=n ; i++) {
            if (!b.contains(i)){
                list.add(i);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (set.contains(arr[i].num)) {
                set.remove(arr[i].num);
            } else {
                cnt++;
                mm[i].add(arr[i].loc);
                for (int j = 0; j < set.size(); j++) {

                }
                mm[i].add(list.remove());
            }
        }
        out.println(cnt);
        for (int i = 1; i < mm.length; i++) {
            if (mm[i] != null && mm[i].size() != 0) {

                out.println(mm[i].get(0) + " " + mm[i].get(1));
            }
        }


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
