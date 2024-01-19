import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1900; i <= 9999; i++) {
            int he = 0;
            String s = String.valueOf(i);

            char[] str = s.toCharArray();
            for (int j = 0; j < str.length; j++) {
                he += str[j] - '0';
            }
            for (int j = 1; j <= 12; j++) {
                int monthSum = 0;
                char[] str1 = String.valueOf(j).toCharArray();
                for (int k = 0; k < str1.length; k++) {
                    monthSum += str1[k] - '0';
                }
                for (int k = 1; k <= getDays(i, j); k++) {
                    int daySum = 0;
                    char[] str2 = String.valueOf(k).toCharArray();
                    for (int l = 0; l < str2.length; l++) {
                        daySum += str2[l] - '0';
                    }
                    if (daySum + monthSum == he) {
                        cnt++;
                    }
                }

            }

        }
        out.println(cnt);


        out.close();

    }

    public static int getDays(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 2) {
            return check(year) ? 29 : 28;
        } else return 30;

    }

    public static boolean check(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else return false;
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
