package Codeforce.MakeItZero;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 功能：
 * 日期：2023-10-18 9:39
 */
public class Main {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            while (T-- > 0) {
                solve(sc);
            }
        }

        public static void solve(Scanner sc) {
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }

            if (n % 2 != 0) {
                System.out.println("4");
                System.out.println("1 " + (n - 1));
                System.out.println("1 " + (n - 1));
                System.out.println((n - 1) + " " + n);
                System.out.println((n - 1) + " " + n);
            } else {
                System.out.println("2");
                System.out.println("1 " + n);
                System.out.println("1 " + n);
            }
        }
    }
