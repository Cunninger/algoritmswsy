import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int sum = scanner.nextInt();
            System.out.println(f(sum));
        }
        scanner.close();
    }

    public static String f(int sum) {
        sum -= 3;
        char[] word = new char[]{'a', 'a', 'a'};
        for (int i = 2; i >= 0; i--) {
            int add = Math.min(sum, 25);
            word[i] += add;
            sum -= add;
        }

        return new String(word);
    }
}