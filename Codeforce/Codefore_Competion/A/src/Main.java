import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        QuickInput scanner = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int t = scanner.nextInt(); // 读取测试用例数量

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // 读取字符串长度
            String a = scanner.next();
            String b = scanner.next();
            String c = scanner.next();

            out.println(isMatch(a, b, c) ? "YES" : "NO");
        }
        out.close();
    }

    private static boolean isMatch(String a, String b, String c) {
        for (int i = 0; i < a.length(); i++) {
            char ai = a.charAt(i);
            char bi = b.charAt(i);
            char ci = c.charAt(i);

            if (ai == bi && ai != ci) {
                // 情况1：a和b相同，且与c不同，可以匹配
                continue;
            } else if (ai != bi) {
                // 情况2：a和b不同，检查c是否与a或b相同
                if (ci != ai && ci != bi) {
                    continue;
                } else {
                    return false; // c与a或b相同，无法构造模板
                }
            } else {
                return false; // a和b相同，且与c也相同，无法构造模板
            }
        }
        return true; // 所有位置都满足条件
    }
}


class  QuickInput
{
    BufferedReader buf;
    StringTokenizer tok;
     QuickInput(){
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    boolean hasNext(){
        while(tok == null || !tok.hasMoreElements()){
            try{
                tok = new StringTokenizer(buf.readLine());
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
    String next(){
        if(hasNext()) return tok.nextToken();
        return null;
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    BigInteger nextBigInteger(){
        return new BigInteger(next());
    }
    BigDecimal nextBigDecimal(){
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
