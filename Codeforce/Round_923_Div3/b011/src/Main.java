import java.util.*;

public class Main {
    private static final int N = 200010;
    private static final char[] b = new char[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        // Initialize array b
        Arrays.fill(b, 'a');

        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            StringBuilder s = new StringBuilder();

            for (int i = 0; i < n; i++) {
                s.append(b[a[i]]);
                b[a[i]]++;
                if (b[a[i]] > 'z') {
                    b[a[i]] = 'a';
                }
            }

            System.out.println(s);
        }

        scanner.close();
    }
}
