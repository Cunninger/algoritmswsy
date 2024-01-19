package HDUOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int C = in.nextInt();
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = in.nextInt();
            }
            Arrays.sort(p);
            int[] prefixSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + p[i];

            }
            int left = 0, right = p[n];
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (check(p, prefixSum, C, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }

    private static boolean check(int[] p, int[] prefixSum, int C, int x) {
        for (int i = p.length - 1; i >= 1; i--) {
            if (p[i] - p[1] > x) {
                continue;
            }
            int j = lowerBound(p, p[i] - x);
            if (prefixSum[i] - prefixSum[j - 1] >= C) {
                return true;
            }
        }
        return false;
    }

    private static int lowerBound(int[] p, int x) {
        int left = 1, right = p.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (p[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}