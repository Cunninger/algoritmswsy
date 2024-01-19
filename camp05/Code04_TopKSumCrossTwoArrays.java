package camp05;

import java.util.PriorityQueue;

/**
 *      两个有序数组，每个数组中取一个数，求和最大的前k个，返回这k个和
 *      两个数组长度都为N
 *      两个数组内部无重复值
 *      要求时间复杂度O(k*logk)
 */
public class Code04_TopKSumCrossTwoArrays {

    public static class HeapNode {
        public int r;
        public int c;
        public int value;

        public HeapNode(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    public static int[] topKSum(int[] a1, int[] a2, int topK) {
        if (a1 == null || a2 == null || topK < 1) {
            return null;
        }
        topK = Math.min(topK, a1.length * a2.length);
        int[] res = new int[topK];

        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        boolean [][]set = new boolean[a1.length][a2.length];

        maxHeap.add(new HeapNode(a1.length-1,a2.length-1,a1[a1.length-1]+a2[a2.length-1]));
        set[a1.length-1][a2.length-1] = true;
        int resIndex = 0;
        while(resIndex != topK){
            HeapNode poll = maxHeap.poll();
            res[resIndex++] = poll.value;
            int r = poll.r;
            int c = poll.c;

            if (r-1>=0 && !set[r-1][c]){
                set[r-1][c] = true;
                maxHeap.add(new HeapNode(r-1,c,a1[r-1]+a2[c]));


            }
            if (c-1>=0 && !set[r][c-1]){
                set[r][c-1] = true;
                maxHeap.add(new HeapNode(r,c-1,a1[r]+a2[c-1]));

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a1 = { 1, 2, 3 };
        int[] a2 = { 4, 5, 6 ,7};
        int topK = 10;
        int[] res = topKSum(a1, a2, topK);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
