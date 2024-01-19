import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x1 = scanner.nextInt();
        long y1 = scanner.nextInt();
        long x2 = scanner.nextInt();
        long y2 = scanner.nextInt();
        long x3 = scanner.nextInt();
        long y3 = scanner.nextInt();
        long x4 = scanner.nextInt();
        long y4 = scanner.nextInt();

        long area1 = (x2 - x1) * (y2 - y1);
        long area2 = (x4 - x3) * (y4 - y3);

        long overlapX = Math.max(0, Math.min(x2, x4) - Math.max(x1, x3));
        long overlapY = Math.max(0, Math.min(y2, y4) - Math.max(y1, y3));

        long overlapArea = overlapX * overlapY;


        long totalArea = area1 + area2 - overlapArea;

        System.out.println(totalArea);
    }
}
