//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int[] arr;
//    static boolean[]used;
//    static PrintWriter out = new PrintWriter(System.out);
//    public static void main(String[] args) {
//        QuickInput in = new QuickInput();
//
//
//        //in.nextInt().....
//        //out.println().....
//        int T = in.nextInt();
//        arr = new int[T];
//        used = new boolean[T];
//        for (int i = 0; i < T; i++) {
//            arr[i] = i + 1;
//        }
//
//        dfs(0);
//
//
//        out.close();
//        // 一定要关流;
//    }
//
//    public static void dfs(int index){
//        if (index==arr.length){
//            for (int i = 0; i < arr.length; i++) {
//                out.printf("%5d",arr[i]);
//            }
//            out.println();
//            return;
//        }
//        for (int i = 0; i <arr.length; i++) {
//            if (!used[i]){
//                arr[index] = arr[i];
//                used[i] = true;
//                dfs(index+1);
//                used[i] = false;
//
//            }
//        }
//    }
//
//
//}
//
//
//class QuickInput {
//    BufferedReader buf;
//    StringTokenizer tok;
//
//    QuickInput() {
//        buf = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    boolean hasNext() {
//        while (tok == null || !tok.hasMoreElements()) {
//            try {
//                tok = new StringTokenizer(buf.readLine());
//            } catch (Exception e) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    String next() {
//        if (hasNext()) return tok.nextToken();
//        return null;
//    }
//
//    int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    long nextLong() {
//        return Long.parseLong(next());
//    }
//
//    double nextDouble() {
//        return Double.parseDouble(next());
//    }
//
//    BigInteger nextBigInteger() {
//        return new BigInteger(next());
//    }
//
//    BigDecimal nextBigDecimal() {
//        return new BigDecimal(next());
//    }
//
//    String nextLine() {
//        try {
//            return buf.readLine();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
import java.util.*;

public class Main {
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        used = new boolean[N];
        permute(N);
    }

    static void permute(int N){
        if (N == 0){
            return;
        }
        permuteHelper(N);
    }

    static void permuteHelper(int N){
        if (path.size() == N){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < N; i++){
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(i + 1); // +1 because we are generating permutations from 1 to N
            permuteHelper(N);
            path.removeLast();
            used[i] = false;
        }
    }
}
