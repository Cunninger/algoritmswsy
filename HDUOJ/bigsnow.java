package HDUOJ;

/**
 * 功能：
 * 日期：2023/12/30 12:56
 */

import java.util.Arrays;
import java.util.Scanner;

public class bigsnow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            long[] v = new long[n];
            for (int i = 0; i < n; i++) {
                v[i] = in.nextLong();
            }
            Arrays.sort(v);
            long k = in.nextLong();
            long left = v[0] * 2, right = v[n - 1] * 2;
            while (left < right) {
                long mid = left + (right - left) / 2;
                if (count(v, mid) >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left);

        }
    }

    private static long count(long[] v, long x) {
        int n = v.length;
        long count = 0;
        for (int i = 0, j = n - 1; i < j; ) {
            if (v[i] + v[j] <= x) {
                count += j - i;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}