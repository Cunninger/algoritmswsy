package camp05;

import java.util.Arrays;

public class minPatches {

        public static int minPathes(int[] arr, int aim) {
            if (arr == null || arr.length < 1 || aim < 0) {
                return 0;
            }

            int range = 0;
            int patches =0;
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                while (range < arr[i] - 1) {
                    range += range+1;
                    patches++;
                    if (range>=aim)
                        return patches;
                }

                range+=arr[i];
                if (range>=aim){
                    return patches;
                }




            }
            // 穷尽数组，range 仍然小于aim
            while (aim>=range+1){
                // range+1<aim 肯定还要进行一次，range+1==aim，要进行最后一次
                range += range+1;
                patches++;
            }
            return patches;
        }

        public static void main(String[] args) {
            int[] arr = { 1, 2, 5 };
            int aim = 100;
            System.out.println(minPathes(arr, aim));
        }

    }

