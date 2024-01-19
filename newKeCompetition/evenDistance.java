package newKeCompetition;

import java.util.Scanner;

public class evenDistance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long a = in.nextLong();// 首项

        long k = in.nextLong();// 公差

        long q = in.nextInt();// 询问次数

        int i = 0;
        while (i < q) {
            long l = in.nextLong();
            long r = in.nextLong();

            if (a % 2 == 1 & k % 2 == 0) {
                // 奇数首项，偶数公差
                System.out.println(1);// 全是奇数
            }
            if (a % 2 == 0 & k % 2 == 0) {
                // 偶数首项，偶数公差
                System.out.println(-1);// 全是偶数
            }

            if (a % 2 == 1 & k % 2 == 1) {
                // 奇数首项，奇数公差
                long s = l + r;

                if (s % 2 == 1) {
                    // 奇偶区间or 偶奇区间
                    System.out.println(0);
                }
                if (l % 2 == 1 & r % 2 == 1) {
                    // 奇奇区间
                    System.out.println(1);
                }
                if (l % 2 == 0 & r % 2 == 0) {
                    // 偶偶区间
                    System.out.println(-1);
                }
            }

            if (a % 2 == 0 & k % 2 == 1) {
                // 偶数首项，奇数公差
                long s = l + r;

                if (s % 2 == 1) {
                    // 奇偶区间or 偶奇区间
                    System.out.println(0);
                }
                if (l % 2 == 1 & r % 2 == 1) {
                    // 奇奇区间
                    System.out.println(-1);
                }
                if (l % 2 == 0 & r % 2 == 0) {
                    // 偶偶区间
                    System.out.println(1);
                }
            }
            i++;
        }
    }
}
