import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of comparisons
            boolean isConsistent = true; // Flag for consistency

            // We use an adjacency matrix to store the comparisons.
            // compMatrix[i][j] is true if ai < aj according to the comparisons.
            boolean[][] compMatrix = new boolean[4][4];

            for (int n = 0; n < N; n++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();

                if (z == 1) {
                    // If the comparison is strict (ai < aj), we record it.
                    compMatrix[x][y] = true;

                    // Check for inconsistency: if ai < aj and aj < ai, it's inconsistent.
                    if (compMatrix[y][x]) {
                        isConsistent = false;
                    }
                }
            }

            // A transitive check is not required because N <= 2,
            // and hence there can't be a situation like ai < aj and aj < ak but ak < ai.

            System.out.println(isConsistent ? "Yes" : "No");
        }

        scanner.close();
    }
}