package classWorktest;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class meetingArrage {
    static class Node {
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.start - o2.start));
        PriorityQueue<Integer> heap = new PriorityQueue<>();// 记录所有会场最早结束时间

        //in.nextInt().....
        //out.println().....

        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            pq.add(new Node(in.nextInt(), in.nextInt()));
        }
        Node[] array = pq.toArray(new Node[0]);// 优先队列转化为数组
        int ans = 1;
        heap.add(array[0].end);

        for (int i = 1; i < k; i++) {
            if (array[i].start >= heap.peek()) {
                heap.poll();
                heap.add(array[i].end);
            } else {
                ans++;
                heap.add(array[i].end);
            }
        }
        out.println(ans);


        out.close();
        // 一定要关流;
    }
}


