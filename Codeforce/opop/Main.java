package Codeforce.opop;

import java.util.*;

public class Main {

    public static void solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        char[] ch = s.toCharArray();

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j);
                if (a.compareTo(b) * c.compareTo(b) >= 0) {
                    System.out.print(a + " " + b + " " + c);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while (t-- > 0)
            solve();
    }
}
