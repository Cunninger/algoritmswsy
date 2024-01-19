import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int t, sum;
        boolean flag = false;
        int[] appear = new int[10001];
        Map<Integer, Integer> link = new TreeMap<>();

        for (int i = left; i <= right; i++) {
            t = i;
            List<Integer> road = new ArrayList<>();
            while (t != 1) {
                sum = 0;
                while (t > 0) {
                    sum += Math.pow(t % 10, 2);
                    t /= 10;
                }
                t = sum;
                if (road.contains(sum)) {
                    break;
                }
                road.add(sum);
                appear[t] = 1;
            }
            if (t == 1) {
                link.put(i, road.size());
            }
        }

        for (Map.Entry<Integer, Integer> it : link.entrySet()) {
            if (appear[it.getKey()] == 0) {
                flag = true;
                System.out.println(it.getKey() + " " + isPrime(it.getKey()) * it.getValue());
            }
        }

        if (!flag) {
            System.out.println("SAD");
        }

        scanner.close();
    }

    public static int isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return 1;
            }
        }
        return 2;
    }
}