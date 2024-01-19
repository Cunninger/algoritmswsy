package leetcode_daily;

import java.util.*;

public class timeToSeeFlowers {
    public static class SegmentTree {
        private int[] max;
        private int[] change;
        private boolean[] update;

        public SegmentTree(int size) {
            int N = size + 1;
            max = new int[N << 2];

            change = new int[N << 2];
            update = new boolean[N << 2];
        }

        private void pushUp(int rt) {
            max[rt] = Math.max(max[rt << 1], max[rt << 1 | 1]);
        }

        // ln表示左子树元素结点个数，rn表示右子树结点个数
        private void pushDown(int rt, int ln, int rn) {
            if (update[rt]) {
                update[rt << 1] = true;
                update[rt << 1 | 1] = true;
                change[rt << 1] = change[rt];
                change[rt << 1 | 1] = change[rt];
                max[rt << 1] = change[rt];
                max[rt << 1 | 1] = change[rt];
                update[rt] = false;
            }
        }

        public void update(int L, int R, int C, int l, int r, int rt) {
            if (L <= l && r <= R) {
                update[rt] = true;
                change[rt] = C;
                max[rt] = C;
                return;
            }
            int mid = (l + r) >> 1;
            pushDown(rt, mid - l + 1, r - mid);
            if (L <= mid) {
                update(L, R, C, l, mid, rt << 1);
            }
            if (R > mid) {
                update(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            pushUp(rt);
        }

        public int query(int L, int R, int l, int r, int rt) {
            //  参数： L,R 表示要查询的区间，l,r 表示当前节点所表示的区间，rt表示当前节点的编号
            // 举个例子怎么查： query(1,3,1,8,1)    1,3表示要查询的区间，1,8表示当前节点所表示的区间，1表示当前节点的编号
            if (L <= l && r <= R) {
                return max[rt];
            }
            int mid = (l + r) >> 1;
            pushDown(rt, mid - l + 1, r - mid);
            int left = 0;
            int right = 0;
            if (L <= mid) {
                left = query(L, R, l, mid, rt << 1);
            }
            if (R > mid) {
                right = query(L, R, mid + 1, r, rt << 1 | 1);
            }
            return Math.max(left, right);
        }
    }

    public static HashMap<Integer, Integer> index(int[][] flowers, int[] people) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int[] flower : flowers) {
            for (int f : flower) {
                if (!map.containsKey(f)) {
                    map.put(f, ++index);
                }
            }
        }

        for (int person : people) {
            if (!map.containsKey(person)) {
                map.put(person, ++index);
            }
        }

        return map;
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        HashMap<Integer, Integer> map = index(flowers, people);
        int[] newPeople = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            newPeople[i] = map.get(people[i]);
        }

        int N = map.size();
        SegmentTree segmentTree = new SegmentTree(N);

        Arrays.sort(flowers, Comparator.comparingInt(a -> a[1]));  

        int idx = 0;
        int[] res = new int[people.length];
        for (int i = 1; i <= N; i++) {
            while (idx < flowers.length && map.get(flowers[idx][1]) == i) {
                int L = map.get(flowers[idx][0]);
                int R = map.get(flowers[idx][1]);
                segmentTree.update(L, R, 1, 1, N, 1);
                idx++;
            }
            for (int j = 0; j < people.length; j++) {
                if (newPeople[j] == i) {
                    res[j] = segmentTree.query(1, i, 1, N, 1);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] flowers = {{1, 6}, {3, 7}, {9,12}, {4, 13}};
        int[] people = {2, 3, 7, 11};
        int[] ans = fullBloomFlowers(flowers, people);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
