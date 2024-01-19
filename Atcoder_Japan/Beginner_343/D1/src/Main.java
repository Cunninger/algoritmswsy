import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), T = sc.nextInt();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, N);

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt(), B = sc.nextInt();
            Map.Entry<Integer, Integer> entry = treeMap.lowerEntry(B);
            if (entry == null) {
                treeMap.put(B, 1);
            } else {
                treeMap.put(B, treeMap.getOrDefault(B, 0) + 1);
                if (entry.getValue() == 1) {
                    treeMap.remove(entry.getKey());
                } else {
                    treeMap.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            System.out.println(treeMap.size());
        }
    }
}
