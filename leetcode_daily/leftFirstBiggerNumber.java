package leetcode_daily;

import java.util.HashMap;

class StockSpanner {
    // 每一个price左侧第一个更大的元素
    public static int MAXN;
    public static int[] arr;  //
    public static int[] stack;// 模拟栈
    public static int[][] ans;// 存答案
    public static int n, r;
    public static HashMap<Integer,Integer> map;


    public StockSpanner() {
        MAXN = 100001;
        arr = new int[MAXN];
        stack = new int[MAXN];
        ans = new int[MAXN][1];
        map = new HashMap<>();
        n = 0;
    }


    public int next(int price) {
        arr[n++] = price;
        r = 0;
        int cur;
        // 遍历阶段
        for (int i = 0; i < n; i++) {
            // i -> arr[i]
            while (r > 0 && arr[stack[r - 1]] >= arr[i]) {
                cur = stack[--r];
                // cur当前弹出的位置，左边最近且小
                ans[cur][0] = r > 0 ? stack[r - 1] : -1;

            }
            stack[r++] = i;
        }
        // 清算阶段
        while (r > 0) {
            cur = stack[--r];
            ans[cur][0] = r > 0 ? stack[r - 1] : -1;

        }
        for (int i = 0;i<n;i++){
            map.put(price,ans[i][0]==-1?1:r-ans[i][0]);
        }
       return map.get(price);
    }


    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */