package Codeforce.day1218;

import java.util.Scanner;

/**
 * 功能：
 * 日期：2023/12/18 20:02
 */
public class problem1620A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String s= sc.next();
            int cntN = 0;
            for (char ss:s.toCharArray()){
              if(ss=='N'){
                    cntN++;
                }
            }

            if (cntN==1){
                System.out.printf("NO");
            }
            else{
                System.out.printf("YES");
            }

        }
    }
}