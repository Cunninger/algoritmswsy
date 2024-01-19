import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        boolean flag1 = true;
        if (arr[0] != 0 && arr[n - 1] != 0) {
            if (Math.abs(arr[0] - arr[n-1]) != 1) {
                flag1 = false;
            }
        }
        if (!flag1) {
            out.println(-1);
        } else {
            int min =Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) continue;
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            if (max - min == 1&& min!=Integer.MAX_VALUE) {
                // 1 1 1 2 2 2 情况1
                // 2 2 2 1 1 1  2
                List<Integer> milist = new ArrayList<>();
                List<Integer> malist = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (arr[i] == 0) continue;
                    if (arr[i] == min) milist.add(i);
                    if (arr[i] == max) malist.add(i);
                }
                if (milist.get(milist.size()-1) < malist.get(0)) {
                    // 1
                    int i;
                    for (i = 0; i <= milist.get(milist.size() - 1); i++) {
                        out.print(min+" ");
                    }
                    for (; i < n; i++) {
                        out.print(max+" ");
                    }


                } else if (malist.get(malist.size() - 1) <= milist.get(0)) {
                    // 2
                    int i;
                    for (i = 0; i <= malist.get(malist.size() - 1); i++) {
                        out.print(max+" ");
                    }
                    for (; i < n; i++) {
                        out.print(min+" ");
                    }

                }
                else {
                    out.println(-1);
                }

            } else if (max - min == 0) {
                if (arr[0] == 0) {
                    out.print((min + 1)+" ");
                    for (int i = 0; i < n-1; i++) {
                        out.print(min+" ");
                    }
                } else {
                    for (int i = 0; i < n - 1; i++) out.print(min+" ");
                    out.print((min + 1)+" ");


                }
                // 全0
            } else if (min==Integer.MAX_VALUE) {
                out.print(1+" ");
                for (int i = 0; i < n-1; i++) {
                    out.print(2+" ");
                }

            } else {
                out.println(-1);
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
