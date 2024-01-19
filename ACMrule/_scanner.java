package ACMrule;
import java.util.*;
public class _scanner {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a+b);
//        }
//    }

    // 判断质数
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int n = sc.nextInt();
//
//            if (n == 1){
//                System.out.println("No");
//            }
//            if (n == 2){
//                System.out.println("Yes");
//            }
//            if (n > 2){
//                int i = 2;
//                while (i < n){
//                    if (n % i == 0){
//                        System.out.println("No");
//                        break;
//                    }
//                    i++;
//                }
//                if (i == n){
//                    System.out.println("Yes");
//                }
//            }
//        }
//    }

    // practice:
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while(sc.hasNext()){
//        int a = sc.nextInt();
//            if (a==1){
//                System.out.println("Yes");
//            }
//            if (a==2){
//                System.out.println("No");
//            }
//
//            if (a>2){
//                int i = 2;
//                while (i<a){
//                    if (a%i==0){
//                        System.out.println("No");
//                        break;
//                    }
//                    i++;
//                }
//                if (i==a){
//                    System.out.println("Yes");
//                }
//            }
//        }
//    }
    // 将数转为二进制：
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int a = sc.nextInt();
//
//            String s = Integer.toBinaryString(a);
//            System.out.println(s);
//        }
//
//    }
    // 不用库函数将数转为二进制：
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int a = sc.nextInt();
//
//            String s = "";
//            while (a!=0){
//                s = a%2+s;
//                a = a/2;
//            }
//            System.out.println(s);
//        }
//    }

















    // practice：binary
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n==0) {
                System.out.println(0);
            }
            else{
                String s = "";
                while (n!=0){
                    s=n%2+s;
                    n/=2;
                }
                System.out.println(s);
            }

        }
    }
}
