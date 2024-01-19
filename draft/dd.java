package draft;

import java.util.Arrays;

/**
 * 功能：
 * 日期：2024/2/16 16:22
 */
public class dd {
    public static void main(String[] args) {
        int[][][] dp = new int[5][5][5];
         for (var i : dp)
         for (var j : i)
      {
          Arrays.fill(j, 1);
         }
        for (var i : dp){
            for (var j : i){
                for (var k : j){
                    System.out.print(k+"");
                }
                System.out.println();
            }
            System.out.println();
        }



    }
}

