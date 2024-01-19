import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int v, no;
    public Node(int v, int no) {
        this.v = v;
        this.no = no;
    }
    public int compareTo(Node a) {
        return Integer.compare(this.v, a.v);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] arr = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new Node(in.nextInt(), i);
        }
        Arrays.sort(arr, 1, n+1);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            mp.put(arr[i].no, i);
        }
        if (n % 2 == 1) {
            int a = (n - 1) / 2 + 1;
            for (int i = 1; i <= n; i++) {
                if (mp.get(i) < a) {
                    System.out.printf("%.1f\n", (arr[a].v + arr[a + 1].v) / 2.0);
                }
                if (mp.get(i) == a) {
                    System.out.printf("%.1f\n", (arr[a - 1].v + arr[a + 1].v) / 2.0);
                }
                if (mp.get(i) > a) {
                    System.out.printf("%.1f\n", (arr[a - 1].v + arr[a].v) / 2.0);
                }
            }
        } else {
            int a = n / 2 + 1;
            for (int i = 1; i <= n; i++) {
                if (mp.get(i) < a) {
                    System.out.printf("%.1f\n", (double)arr[a].v);
                }
                if (mp.get(i) >= a) {
                    System.out.printf("%.1f\n", (double)arr[a - 1].v);
                }
            }
        }
    }
}