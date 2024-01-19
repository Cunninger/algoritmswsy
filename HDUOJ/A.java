package HDUOJ;

import java.util.Scanner;

/**
 * 功能：
 * 日期：2023/12/30 12:17
 */

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T--!=0){
            int n = sc.nextInt();
            String s= sc.next();
            if (n>5){
                System.out.println("sleep");
            }
            else {
                System.out.println(s);
            }
        }
    }
}