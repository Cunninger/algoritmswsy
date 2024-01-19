import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int score = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                score++;
            } else {
                score--;
            }
            if (score < 0) {
                score = 0;
            }
        }
        System.out.println(score);
        scanner.close();
    }
}