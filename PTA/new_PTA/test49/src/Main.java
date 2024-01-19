import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] M = new int[N];
        for (int i = 0; i < N; i++) {
            M[i] = scanner.nextInt();
        }

        int total = 0;
        for (int i = 0; i < N; i++) {
            total += M[i];
        }

        int[][] seats = new int[total][10];
        int seatNum = 1;
        int round = 0;
        while (seatNum <= total * 10) {
            for (int i = 0; i < N; i++) {
                if (round < M[i]) {
                    seats[round * N + i][seatNum % 10 == 0 ? 9 : seatNum % 10 - 1] = seatNum;
                    seatNum++;
                }
            }
            round++;
        }

        for (int i = 0; i < total; i++) {
            System.out.println("#" + (i / M[i % N] + 1));
            for (int j = 0; j < 10; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(seats[i][j]);
            }
            System.out.println();
        }
    }
}