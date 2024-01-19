import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        String text = scanner.nextLine();
        int length = text.length();
        int rows = (length + N - 1) / N;
        char[][] matrix = new char[rows][N];
        for (int i = 0; i < length; i++) {
            int row = i / N;
            int col = i % N;
            matrix[row][N - 1 - col] = text.charAt(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = rows-1; j >= 0; j--) {
                System.out.print(matrix[j][N - 1 - i] == 0 ? ' ' : matrix[j][N - 1 - i]);
            }
            System.out.println();
        }
    }
}