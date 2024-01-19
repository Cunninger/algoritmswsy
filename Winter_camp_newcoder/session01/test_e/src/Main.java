import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Chicken{
        int place;
        int score;

        public Chicken(int p,int s){
            place = p;
            score = s;
        }
    }
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        while (N-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            Chicken[]chickens = new Chicken[n];
            for (int i = 0; i < chickens.length; i++) {
                chickens[i] = new Chicken(i+1,in.nextInt());

            }

            for (int i = 0; i < m; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if (x==1||y==1){
                    chickens[0].score+=3;
                }else {
                   if (chickens[x-1].score<chickens[y-1].score&&chickens[x-1].score+3<=3&&chickens[x-1].score<chickens[y-1].score){

                   }
                }

            }

           Arrays.sort(chickens, (Chicken o1, Chicken o2) -> o2.score - o1.score);
            int index = 0;
            for (int i = 0; i < chickens.length; i++) {
                if (chickens[i].place==1){
                    index = i+1;
                }

            }
            out.println(index);




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
