package camp05;

import java.util.HashMap;

public class mostEorCount {
    public int mostEOR(int []arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int eor = 0;

        int []dp = new int[arr.length];// dp[i] 表示arr[0..i]范围上，异或和为eor的子数组最多有多少个

        HashMap<Integer, Integer> map = new HashMap<>(); //  key:某个前缀异或和  value:该前缀异或和最早出现的位置

        map.put(0,-1);      // 表示如果查到-1，说明dp[i] = 1,前面没有异或和为0的子数组

        dp[0] = arr[0] == 0 ? 1 : 0; // arr[0..0]范围上，异或和为0的子数组最多有1个,因为当区间只有一个数时，异或和即本身

        map.put(arr[0],0);

        for (int i = 1;i< arr.length;i++){
            eor ^= arr[i];

            if (map.containsKey(eor)){
                int preEorIndex = map.get(eor);
                dp[i] = preEorIndex == -1 ? 1 : (dp[preEorIndex] + 1);


            }
            dp[i] = Math.max(dp[i-1],dp[i]);
            map.put(eor,i);
        }
        return dp[arr.length-1];
    }
}
