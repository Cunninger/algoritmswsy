//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.StringTokenizer;
//
//public class Main {
//    static char[][] mat;
//
//    public static void main(String[] args) {
//        QuickInput in = new QuickInput();
//        PrintWriter out = new PrintWriter(System.out);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int x = in.nextInt();
//        int y = in.nextInt();
//
//        mat = new char[n][m];
//        for (int i = 0; i < mat.length; i++) {
//            mat[i] = in.next().toCharArray();
//        }
//        int p = in.nextInt();
//        while (p-- > 0) {
//            int q = in.nextInt();
//            while (q-- > 0) {
//                int op = in.nextInt();
//                int z = in.nextInt();
//
//                if (op == 1) {
//                    mat[z - 1] = roa2(mat[z - 1]);
//                } else {
//                    // 取出第z列
//                    char[] col = new char[n];
//                    for (int i = 0; i < n; i++) {
//                        col[i] = mat[i][z - 1];
//                    }
//                    col = roa2(col);
//                    for (int i = 0; i < n; i++) {
//                        mat[i][z - 1] = col[i];
//                    }
//                }
//                // 打印mat
//                for (int i = 0; i < mat.length; i++) {
//                    for (int j = 0; j < mat[i].length; j++) {
//                        out.print(mat[i][j]);
//                    }
//                    out.println();
//                }
//            }
//            out.println(mat[x - 1][y - 1]);
//            out.close();
//        }
//
//        private static char[] roa2 ( char[] chars){
//            String s = new String(chars);
//            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
//            return s.toCharArray();
//        }
//    }
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
