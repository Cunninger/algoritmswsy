package Codeforce.ArrayMerge;

import java.util.Scanner;

import java.util.Arrays;

public class Main {
    static final int N = 200010;
    static final int MOD = (int)1e9 + 7;

    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] c1 = new int[n * 2+1];
        int[] c2 = new int[n * 2+1];

        Arrays.fill(c1, 0);
        Arrays.fill(c2, 0);

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int cnt1 = 1, cnt2 = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                c1[a[i - 1]] = Math.max(c1[a[i - 1]], cnt1);
                cnt1 = 1;
            } else {
                cnt1++;
            }

            if (b[i] != b[i - 1]) {
                c2[b[i - 1]] = Math.max(c2[b[i - 1]], cnt2);
                cnt2 = 1;
            } else {
                cnt2++;
            }
        }

        c1[a[n - 1]] = Math.max(c1[a[n - 1]], cnt1);
        c2[b[n - 1]] = Math.max(c2[b[n - 1]], cnt2);
        long res = 0;

        for (int i = 0; i < n * 2; i++) {
            res = Math.max(res, (long)c1[i] + c2[i]);
        }

        System.out.println(res);
    }
}
