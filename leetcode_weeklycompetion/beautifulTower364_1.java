package leetcode_weeklycompetion;

import java.util.List;

public class beautifulTower364_1 {
    public long maximumSumOfHeights(List<Integer> maxHeights){
        long maxH = 0;
        int len = maxHeights.size();

        // 枚举 分别计算 峰值 在 i 处所能达到的美丽塔最大高度和

        for (int i = 0;i<len;i++){
            long sum = 0;// 维护局部最大

            // h 就是 本轮枚举最大峰值，即所有塔高度不能超过 h

            int h = maxHeights.get(i);

            int l = i-1;
            int r = i+1;

            int left = h,right = h;
            // 左右 两边的 塔高不超过 h

            while (l>=0){
                sum += Math.min(left,maxHeights.get(l));
                // left 维护i 前面 的塔 的最大高度
                left = Math.min(left,maxHeights.get(l));

                l--;
            }
            sum += h;// 加上 i 处的塔高度

            // 从i 出发，依次遍历 i 后面的 塔

            while( r < len){
                sum += Math.min(right,maxHeights.get(r));
                right = Math.min(right,maxHeights.get(r));
                r++;
            }

            maxH = Math.max(maxH,sum);// 维护全局最大

        }
        return maxH;
    }

    public static void main(String[] args) {
        beautifulTower364_1 bt = new beautifulTower364_1();
        System.out.println(bt.maximumSumOfHeights(List.of(1,2,3,4,3,2,1)));//答案是： 25
    }

}
