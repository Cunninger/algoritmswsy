package Codeforce.BGameWithArrays;

import java.util.Scanner;

public class Main {

    static final int N = 500010;
    static final long INF = (long) 1e18 + 7;
    static int[] mn1 = new int[N], mn2 = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int t = 1, minn = Integer.MAX_VALUE;
        for (int i = 1, m; i <= n; i++) {
            m = scanner.nextInt();
            mn1[i] = mn2[i] = Integer.MAX_VALUE;
            for (int j = 1, x; j <= m; j++) {
                x = scanner.nextInt();
                if (x <= mn1[i]) {
                    mn2[i] = mn1[i];
                    mn1[i] = x;
                } else if (x < mn2[i]) {
                    mn2[i] = x;
                }
            }
            if (mn2[i] < mn2[t]) {
                t = i;
            }
            minn = Math.min(minn, mn1[i]);
        }
        //
        if (n == 1) {
            System.out.println(minn);
            return;
            //  
            //
        }
        long ans = minn;
        for (int i = 1; i <= n; i++) {
            if (i != t) {
                ans += mn2[i];
            }
        }
        System.out.println(ans);
    }
}
