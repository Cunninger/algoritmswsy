import java.util.Scanner;

public class Main {
    static final int MOD = 1000_000_007;
    static char[] str;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { // 持续读取输入，直到没有更多输入为止
            String s = sc.next();
            str = s.toCharArray();
            System.out.println(numDecodings());
        }
        sc.close();
    }

    public static int numDecodings() {
         N = str.length;

        return f(0);
    }

    public static int f(int i) {
        if (i == N) {
            return 1;
        }

        if (str[i] == '0') {
            return 0;
        }
        // 单开
        int ans = str[i] == '*' ? 9 : 1;
        if (i+1< str.length){
            ans+=f(i+1);
        }
        // 双
        int num1 = str[i] - '0';
        if (str[i] != '*') {
            if (i + 1 < N && str[i + 1] != '*') {
                int num2 = str[i + 1] - '0';
                // num1 num2
                if (num1 == 1 && num2 >= 1 && num2 <= 9) {
                    ans += f(i + 2);
                } else if (num1 == 2 && num2 >= 1 && num2 <= 6) {
                    ans += f(i + 2);
                }
            } else if (i + 1 < N && str[i + 1] == '*') {
                if (num1 == 1) {
                    ans += 9 * f(i + 2);
                } else if (num1 == 2) {
                    ans += 6 * f(i + 2);
                }

            }
        } else {
            if (i + 1 < N && str[i + 1] != '*') {
                // * num
                int num2 = str[i + 1] - '0';
                if (num2 >= 0 && num2 <= 6) {
                    ans += 2 * f(i + 2);
                } else if (num2 > 6 && num2 <= 9) {
                    ans += f(i + 2);
                }

            } else if (i + 1 < N && str[i + 1] == '*') {

                // * *
                ans+=15*f(i+2);
            }

        }
        return ans % MOD;
    }
}
