package camp05;
/**
 * 一个数组的异或和是指数组中所有的数异或在一起的结果
 * 给定一个数组arr,求最大子数组异或和。
 */

import java.util.Scanner;

import static camp05.maxEor.NumTrie.maxXorSubArray6;

public class maxEor {


    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // System.out.println(maxXorSubarray(array));
        // System.out.println(maxXorSubarray1(array));
        System.out.println(maxXorSubArray6(array));

    }


    public static int maxXorSubarray(int[] nums) {
        int maxXor = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int xor = nums[i];

            //maxXor = Math.max(maxXor,xor);
            for (int j = i + 1; j < nums.length; j++) {
                xor ^= nums[j];
                maxXor = Math.max(maxXor, xor);
            }
        }
        return maxXor;
    }


    // 利用Eor 预处理数组
    public static int maxXorSubarray1(int[] nums) {
        int[] eor = new int[nums.length];
        eor[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            eor[i] = eor[i - 1] ^ nums[i];
        }

        int maxXor = Integer.MIN_VALUE;

        for (int j = 0; j < nums.length; j++) { // 控制右边界
            for (int i = 0; i <= j; i++) {      // 控制左边界
                maxXor = Math.max(maxXor, i == 0 ? eor[j] : eor[i - 1] ^ eor[j]);
                // 为什么是eor[i-1]^eor[j]? 因为eor[i-1]是从0到i-1的异或和，eor[j]是从0到j的异或和，eor[i-1]^eor[j]就是从i到j的异或和
                // 为什么 i == 0 ? 要特殊判断一下？ i == 0,说明左边界是0，那么从0到j的异或和就是eor[j]

            }
        }
        return maxXor;
    }

    // 利用前缀树 + 贪心

    public static class Node {
        public Node[] nexts = new Node[2];// 0 1
    }

    public static class NumTrie {


        public Node head = new Node();

        private void add(int newNum) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {

                int path = ((newNum >> move) & 1); // 从高位到低位，依次取出每一位的值 比如：

                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];

                cur = cur.nexts[path]; // cur 指向下一个节点
            }
        }

        public int maxXor(int sum) {
            Node cur = head;

            int res = 0;        // 用来记录异或的结果

            for (int move = 31; move >= 0; move--) {
                int path = (sum >> move) & 1;

                // 期待的路
                int best = move == 31 ? path : (path ^ 1);
                // 如果最高位i == 31，那么期待的路就和path相同，如果不是最高位，那么期待的路就是path相反的路
                // 这里是考虑到 sum 正负的问题：
                // 如果sum是正数，那么最高位是0，期待的路就是1，因为0^0=0
                // 如果sum是负数，那么最高位是1，期待的路就是0, 因为1^1=0
                // 正数还是正数，负数变成正数

                best = cur.nexts[best] != null ? best : (best ^ 1); // 如果期待的路不为空，那么就走期待的路，如果期待的路为空，那么就走相反的路
                // 为什么期待的路为空，就走相反的路？因为期待的路为空，说明期待的路走不通，那么就只能走相反的路

                // (path^best)当前位 异或完的结果
                res = res|(path ^ best) << move;
                //  res |= (path^best)<<move; 为什么要左移move位？ 因为异或完的结果是从高位到低位，所以要左移move位
                // path^best 是0或者1，左移move位，就是把path^best放到正确的位置上

                cur = cur.nexts[best];

            }
            return res;
        }


        public static int maxXorSubArray6(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;

            int eor = 0;

            NumTrie numTrie = new NumTrie();

            numTrie.add(0);  // 一定要先加0吗？ 不加0，会有什么问题？ 会有问题，比如数组中只有一个数，那么最大异或和就是这个数本身，如果不加0，那么最大异或和就是0

            for (int i = 0; i < arr.length; i++) {
                //
                eor ^= arr[i];
                max = Math.max(max, numTrie.maxXor(eor));// numTrie.maxXor返回的是eor[j] 与 前缀树中的某个数异或的最优解
                numTrie.add(eor);
            }
            return max;
        }
    }  // 总结：代码流程
    // 1.先把0加入到前缀树中
    // 2.从左到右遍历数组，依次异或，每次异或完，都把异或结果加入到前缀树中
    // 3.每次加入到前缀树中，都要求一下最大异或和
    // 4.最后返回最大异或和
    // 每次产生新的异或和都要加入到 前缀树中吗？ 不是，只有当产生新的异或和的时候，才加入到前缀树中



}
