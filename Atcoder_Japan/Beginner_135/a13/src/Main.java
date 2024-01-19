import java.util.*;
public class Main{
    static int avg;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        if (isInteger(A,B)){
            System.out.println(avg);
        }
        else{
            System.out.println("IMPOSSIBLE");
        }

    }

    public static boolean isInteger(double A,int B){
        double k = (A+B)/2;
        if (k==Math.floor(k)){
            avg = (int)k;
            return true;
        }
        else{
            return false;
        }
    }
}