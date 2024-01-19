import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        int c = sc.nextInt();
        int n1 = Integer.parseInt(b,a);

        String ss = Integer.toString(n1,c);
        System.out.println(ss.toUpperCase());

    }
}