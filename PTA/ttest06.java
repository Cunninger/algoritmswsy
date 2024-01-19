package PTA;

import java.util.*;

public class ttest06 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxLen = 0;
        int startNum = 0;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            int temp = N;
            int j = i;
            while (temp % j == 0) {

                temp /= j;
                j++;
            }

            if (j - i > maxLen) {
                maxLen = j - i;
                startNum = i;
            }


        }

        if (maxLen == 0) {
            System.out.println(1);
            System.out.println(N);
        } else {
            System.out.println(maxLen);
            for (int i = 0; i < maxLen; i++) {
                if (i != 0) System.out.print("*");
                System.out.print(i + startNum);
            }
        }
    }
}