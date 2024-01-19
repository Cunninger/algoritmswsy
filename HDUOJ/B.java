package HDUOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 功能：
 * 日期：2023/12/30 12:17
 */

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T--!=0){
            int n = sc.nextInt();
            int []pack = new int[n];
            for (int i = 0;i<n;i++){
                pack[i] = sc.nextInt();
            }

            int []thing = new int[n];
            for (int i = 0;i<n;i++){
                thing[i] = sc.nextInt();
            }
            Arrays.sort(pack);
            Arrays.sort(thing);
            int i;
            for (i = 0; i < n ; i++) {
                if (pack[i]<thing[i]){
                    System.out.println("NO");
                    break;
                }


            }
            if (i==n){
                System.out.println("YES");
            }


        }
    }
}