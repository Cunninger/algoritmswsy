import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());
        Node head = new Node(0), tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        Map<Integer, Node> map = new HashMap<>();
        map.put(0, head);
        while (q-- > 0) {
            String[] parts = reader.readLine().split(" ");
            int op = Integer.parseInt(parts[0]);
            if (op == 1) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                Node node = new Node(x);
                Node prev = map.get(y);
                Node next = prev.next;
                node.prev = prev;
                node.next = next;
                prev.next = node;
                next.prev = node;
                map.put(x, node);
            } else {
                int x = Integer.parseInt(parts[1]);
                Node node = map.get(x);
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                map.remove(x);
            }
        }
        List<Integer> list = new ArrayList<>();
        Node node = head.next;
        while (node != tail) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list.size());
        for (int x : list) {
            System.out.print(x + " ");
        }
    }
}
