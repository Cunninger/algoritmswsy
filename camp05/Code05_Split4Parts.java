package camp05;

import java.util.HashMap;

public class Code05_Split4Parts {
    public boolean isSplit(int[] arr) {
        // 求前缀和数组
        if (arr == null || arr.length == 0) return false;

        //int []sum = new int[arr.length];

        int sum = arr[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            map.put(sum, i);
            sum += arr[i];

        }
        int leftSum = arr[0];// 初始化为第一刀左侧的累加和

        for (int s1 = 1; s1 < arr.length - 5; s1++) {
            int ckeckSum = 2 * leftSum + arr[s1];
            if (map.containsKey(ckeckSum)) {
                int s2 = map.get(ckeckSum);
                ckeckSum += arr[s2] + leftSum;
                if (map.containsKey(ckeckSum)) {
                    int s3 = map.get(ckeckSum);
                    ckeckSum += arr[s3] + leftSum;
                    if (ckeckSum==sum) {
                        return true;
                    }
                }

            }
            leftSum += arr[s1];


        }
        return false;
    }

    public static void main(String[] args) {
        Code05_Split4Parts c = new Code05_Split4Parts();
        int[] arr = {3,2,4,1,4,9,5,11,2,2,1};
        System.out.println(c.isSplit(arr));// true
    }
}
