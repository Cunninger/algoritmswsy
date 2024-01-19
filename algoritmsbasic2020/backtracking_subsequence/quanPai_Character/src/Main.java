import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] used;
    static char[] str;
    static LinkedList<String> path = new LinkedList<>();
    static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        //in.nextInt().....
        //out.println().....
        str = in.nextLine().toCharArray();
        used = new boolean[str.length];
        dfs();
        for (var i : ans) {
            for (var j : i) {
                out.print(j + " ");
            }
            out.println();
        }


        out.close();
        // 一定要关流;
    }

    private static void dfs() {
        if (path.size() == str.length) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(String.valueOf(str[i]));
                dfs();
                used[i] = false;
                path.removeLast();
            }
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
//import java.util.*;
//
//public class Main {
//    static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
//    static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
//    static boolean[] used;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        scanner.close();
//
//        used = new boolean[nums.length];
//        permuteHelper(nums);
//
//        for (List<Integer> perm : result) {
//            for (int num : perm) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static void permuteHelper(int[] nums){
//        if (path.size() == nums.length){
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++){
//            if (used[i]){
//                continue;
//            }
//            used[i] = true;
//            path.add(nums[i]);
//            permuteHelper(nums);
//            path.removeLast();
//            used[i] = false;
//        }
//    }
//}
