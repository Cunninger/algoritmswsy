import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = scanner.nextInt();
        }

        for (int i = N - 2; i >= 0; i--) {
            if (H[i] > H[i + 1]) {
                H[i]--;
            }
            if (H[i] > H[i + 1]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
