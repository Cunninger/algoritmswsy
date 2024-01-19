import java.util.Scanner;

public class Main {
    static int n, m, ans;
    static int[] p, num;
    static int[][] a;

    // 判断该二进制数所代表的开关状态能否打开所有灯
    // 能就返回true,不能返回false
    static boolean check(int x) {
        for (int i = 1; i <= m; i++) {
            int s = 0;
            for (int j = 1; j <= num[i]; j++) {
                // 判断控制第i盏灯的第j个开关的“开”或“关”的情况
                if ((x & (1 << (a[i][j] - 1))) != 0) {
                    s++;
                }
            }
            if (s % 2 != p[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        p = new int[m + 1];
        num = new int[m + 1];
        a = new int[20][20];

        for (int i = 1; i <= m; i++) {
            num[i] = in.nextInt();
            for (int j = 1; j <= num[i]; j++) {
                a[i][j] = in.nextInt();
                // 将开关编号指向对应的二进制数位
            }
        }
        for (int i = 1; i <= m; i++) {
            p[i] = in.nextInt();
        }

        ans = 0;
        // 暴力枚举并判断
        // 因为最多只会有2^n种情况，所以我们从0枚举到2^n-1就行了
        for (int i = 0; i < (1 << n); i++) {
            if (check(i)) {
                ans++;
            }
        }
        System.out.println(ans);
        in.close();
    }
}