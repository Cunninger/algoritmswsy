import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] monster = new int[n + 2];
        int[] hero = new int[n + 1];
        for (int i = 1; i <= n + 1; i++) {
            monster[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            hero[i] = sc.nextInt();
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                if (hero[i] >= monster[i + j]) {
                    hero[i] -= monster[i + j];
                    ans += monster[i + j];
                    monster[i + j] = 0;
                } else {
                    ans += hero[i];
                    monster[i + j] -= hero[i];
                    hero[i] = 0;
                }
            }
        }
        System.out.println(ans);
    }
}
