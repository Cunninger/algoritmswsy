package leetcode_daily;

import java.util.Arrays;

public class earliestBlossomTime {
        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            int n = plantTime.length;
            var id = new Integer[n];

            for (int i = 0;i<n;i++){
                id[i] = i;

            }
            // 0 1 2 3 4 5 6......

            Arrays.sort(id,(i, j)->growTime[j]-growTime[i]);
            // 按生长时间的 长---> 短

            int ans = 0, days = 0;
            for (int i:id){
                days+=plantTime[i];

                ans = Math.max(ans,days+growTime[i]);
            }
            return ans;
        }

    public static void main(String[] args) {
        earliestBlossomTime ebt = new earliestBlossomTime();
        System.out.println(ebt.earliestFullBloom(new int[]{1,4,3},new int[]{2,3,1}));
    }
}
