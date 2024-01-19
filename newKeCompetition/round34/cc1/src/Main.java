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

        List<String> res = new ArrayList<>();
        String nstr = in.nextLine();
        for (int i = 0; i < nstr.length(); ) {
            int num = nstr.charAt(i) - '0';
            if (num % 2 == 0) {
                res.add(nstr.charAt(i) + "");
                i++;
            } else {
                String s = nstr.charAt(i) + "";
                i++;
                while (i < nstr.length() &&new BigInteger(s+nstr.charAt(i)).mod(new BigInteger("2")).intValue()!=0) {
                    s += nstr.substring(i, i + 1);
                    i++;
                }

                if (i<nstr.length()){
                    s+=nstr.substring(i,i+1);
                    i++;
                }
                res.add(s);
            }
        }
        Collections.sort(res,(a,b)->new BigInteger(a).compareTo(new BigInteger(b)));
        for(String s:res){
            out.println(s);
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
