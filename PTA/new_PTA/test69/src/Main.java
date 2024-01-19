import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pressures = new int[4];
        int maxP = 0;
        for (int i = 0; i < 4; i++) {
            pressures[i] = scanner.nextInt();
            if (pressures[i] > maxP) {
                maxP = pressures[i];
            }
        }
        int minA = scanner.nextInt();
        int threshold = scanner.nextInt();

        int alarmCount = 0;
        int alarmIndex = 0;
        for (int i = 0; i < 4; i++) {
            if (pressures[i] < minA || maxP - pressures[i] > threshold) {
                alarmCount++;
                alarmIndex = i + 1;
            }
        }

        if (alarmCount == 0) {
            System.out.println("Normal");
        } else if (alarmCount == 1) {
            System.out.println("Warning: please check #" + alarmIndex + "!");
        } else {
            System.out.println("Warning: please check all the tires!");
        }
    }
}
