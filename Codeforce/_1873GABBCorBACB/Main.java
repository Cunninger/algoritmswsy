package Codeforce._1873GABBCorBACB;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        String s = scanner.next();
        int[] a = new int[s.length() + 2];
        Arrays.fill(a, 0);
        StringBuilder ss = new StringBuilder();
        int l = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                if (l != 0) {
                    a[l]++;
                } else {
                    ss.append('A');
                    len++;
                    l = len;
                    a[l]++;
                }
            } else {
                ss.append('B');
                len++;
                l = 0;
            }
        }
        int q = 0;
        int[][] dp = new int[ss.length() + 2][2];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        ss.insert(0, ' ');
        int ans = 0;
        for (int i = 1; i < ss.length(); i++) {
            if (ss.charAt(i) == 'B') {
                dp[i][0] = Math.max(dp[q][0] + a[i - 1], dp[q][1]);
                dp[i][1] = Math.max(dp[q][1], dp[q][0]) + a[i + 1];
                ans = Math.max(Math.max(ans, dp[i][0]), dp[i][1]);
                q = i;
            }
        }
        System.out.println(ans);
    }
}
