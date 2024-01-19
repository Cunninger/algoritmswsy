package leetcode_daily;

public class bestTimeBuySell {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int idx = prices.length;
            for (int i = 0;i<prices.length;i++){
                if (min > prices[i]){
                    min = prices[i];
                    idx = i;
                }
            }
            if (idx==prices.length-1)return 0;
            // 找最小数和对应下标

            // 继续往后找，最大的数

            int subMax = Integer.MIN_VALUE;
            for (int i = idx+1;i<prices.length;i++){
                if ((subMax < prices[idx]) && (prices[i] > min)){
                    subMax = prices[idx];
                }
            }
            if (subMax == Integer.MIN_VALUE)return 0;
            else{
                return subMax - min;
            }

        }

    public static void main(String[] args) {
        bestTimeBuySell bt = new bestTimeBuySell();
        System.out.println(bt.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    }
