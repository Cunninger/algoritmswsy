import java.util.Scanner;

public class Main {
    private static final int maxn = 2020;
    private static final long mod = 1000000007;
    private static long[] fac = new long[maxn];
    private static long[] inv = new long[maxn];

    public static void main(String[] args) {
        prepare();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        for (int i = 1; i <= m; ++i) {
            System.out.println(C(n - m + 1, i) * C(m - 1, i - 1) % mod);
        }
        scanner.close();
    }

    private static void prepare() {
        fac[0] = 1;
        for (int i = 1; i <= 2000; ++i) {
            fac[i] = fac[i - 1] * i % mod;
        }

        inv[1] = 1;// 表示i数字的逆元
        for (int i = 2; i <= 2000; ++i) {
            inv[i] = (mod - mod / i) * inv[(int) (mod % i)] % mod;
        }
        inv[0] = 1;// 表示i！的逆元
        for (int i = 1; i <= 2000; ++i) {
            inv[i] = inv[i - 1] * inv[i] % mod;
        }

    }

    private static long C(long n, long m) {
        if (n < m) {
            return 0;
        }
        return fac[(int) n] * inv[(int) m] % mod * inv[(int) (n - m)] % mod;
    }
}
