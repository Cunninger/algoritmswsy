package leetcode_daily;

import java.util.ArrayDeque;
import java.util.Deque;

class leftFirstBiggerNumber {
    class StockSpanner {
        private final Deque<int[]> stack = new ArrayDeque<>();
        private int curDay = -1;

        // stack.peek()[0]代表天数
        // stack.peek()[1]代表价格
        public StockSpanner() {
            stack.push(new int[]{-1, Integer.MAX_VALUE});
        }

        public int next(int price) {
            while (price >= stack.peek()[1]) {
                stack.pop();
                // 如果当前的price大于等于栈顶元素，把头部的全部清空
                // 从头部移除元素
            }
            int ans = ++curDay - stack.peek()[0];
            stack.push(new int[]{curDay, price});
            return ans;
        }
    }

    public static void main(String[] args) {
        StockSpanner obj = new leftFirstBiggerNumber().new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
