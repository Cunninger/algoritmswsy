import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            Map<Character, Integer> mp = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (mp.getOrDefault(c, 0) == a[i]) {
                        System.out.print(c);
                        mp.put(c, mp.getOrDefault(c, 0) + 1);
                        break;
                    }
                }
            }

            System.out.println();
        }

        scanner.close();
    }
}
