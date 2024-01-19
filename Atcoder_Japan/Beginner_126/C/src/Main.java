import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double ret = 0.0;

        for (int i = 1; i <= a; i++) {
            double tmp = 1.0 / a;
            int now = i;
            while (now < b) {
                now *= 2;
                tmp /= 2.0;
            }
            ret += tmp;
        }

        System.out.printf("%.12f\n", ret);
        scanner.close();
    }
}