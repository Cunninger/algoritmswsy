//
//package Codeforce._907test;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) {
//        QuickInput in = new QuickInput();
//        PrintWriter out = new PrintWriter(System.out);
//
//
//        int cnt = in.nextInt();
//        while (cnt-- > 0) {
//
//            int N = in.nextInt();
//            int[] arr = new int[N];
//            for (int i = 0; i < N; i++) {
//                arr[i] = in.nextInt();
//            }
//            if (isUp(arr)) {
//                out.println("YES");
//            }
//
//            for (int m = 0; m <= Math.log(N); m++) {
//
//                    for (int i = 1; i <= Math.pow(2, m); i++) {
//
//                        arr[i - 1] -=1;
//                        if (arr[i-1]<0){
//                            break;
//
//
//                    }
//
//                    if (arr[])
//                    if (isUp(arr)) {
//                        out.println("YES");
//                    }
//                }
//
//
//            }
//            out.println("NO");
//
//        }
//
//        out.close();
//        // 一定要关流;
//    }
//
//    public static boolean isUp(int[] arr) {
//        boolean flag = true;
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] < arr[i - 1]) {
//                flag = false;
//                break;
//            }
//        }
//
//        return flag;
//    }
//}
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
//        if (hasNext())
//            return tok.nextToken();
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
//}
