package PTA;

/**
 * 功能：
 * 日期：2024/1/17 8:19
 */
import java.util.*;
public class test10 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int []n = new int[3];

            n[0] = sc.nextInt();
            n[1] = sc.nextInt();
            n[2] = sc.nextInt();


        Arrays.sort (n);
        System.out.print(n[0]+"->"+n[1]+"->"+n[2]);


    }
}