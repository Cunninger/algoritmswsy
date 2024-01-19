
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int jiaDrink = 0;
    static int yiDrink = 0;

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);


        int jiaC = in.nextInt()+1;
        int yiC = in.nextInt()+1;
        int T = in.nextInt();
        int t = T;
        while (T-- > 0) {
            int jiaS = in.nextInt();
            int jiaH = in.nextInt();
            int yiS = in.nextInt();
            int yiH = in.nextInt();
            if (jiaS + yiS == jiaH && jiaS + yiS != yiH) {

                jiaDrink++;
                if (jiaDrink == jiaC) {
                    out.println("A");
                    out.println(yiDrink);
                    break;

                }

            }
            else if (jiaS + yiS != jiaH && jiaS + yiS == yiH) {

                yiDrink++;
                if (yiDrink == yiC) {
                    out.println("B");
                    out.println(jiaDrink);
                    break;
                }
            }
            else {
                continue;
            }



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
