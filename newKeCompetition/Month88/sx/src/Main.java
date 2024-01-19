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
        int x = in.nextInt();
        int n = in.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();
        while (n-- > 0) {
            char ch = in.next().charAt(0);
            int w = in.nextInt();
            map.put(ch, w);


        }
        while (x!=0){
            for(Map.Entry<Character,Integer> unit:map.entrySet()){
                if (unit.getValue()==x){
                    out.print(unit.getKey());
                }
                else {
                    if (unit.getValue()<x){
                        x-=unit.getValue();
                        map.put(unit.getKey(),unit.getValue()-1);
                    }
                }
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
