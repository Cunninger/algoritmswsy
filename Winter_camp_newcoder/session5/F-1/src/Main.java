import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            ArrayList<Long> a = new ArrayList<>(Collections.nCopies(n + 1, 0L));
            // nCopies() 方法用于返回由指定对象的 n 个副本组成的不可变列表。
            // 0l表示long类型的0
            for (int i = 1; i <= n; i++) {
                a.set(i, scanner.nextLong());
                //a.set() 方法用于用指定的元素替换此列表中指定位置上的元素。
                //a.add() 方法用于在列表的结尾添加指定的元素。
            }
            if (solve(a, n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    private static boolean solve(ArrayList<Long> a, int n) {
        long cnt = 0;
        if (n % 2 == 0) {
            return true;
        }
        for (int i = n - 1; i >= 2; i -= 2) {
            long addForI = cnt * i;// i位置需要加的次数
            a.set(i, a.get(i) + addForI);//     i位置加上次数
            a.set(i - 1, a.get(i - 1) + cnt * (i - 1));//   i-1位置加上次数
            if (a.get(i) > a.get(i + 1)) {
                return false;
            }
            long t = (a.get(i + 1) - a.get(i)) / i;//   i+1位置需要加的次数
            a.set(i, a.get(i) + t * i);
            a.set(i - 1, a.get(i - 1) + t * (i - 1));
            cnt += t;
        }
        for (int i = 1; i < a.size() - 1; i++) {
            if (a.get(i) > a.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
