package Luoguquestion;
import java.util.*;
public class test01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();
        int []mArray = new int[n];
        for (int i = 0;i<n;i++){
            mArray[i] = sc.nextInt();
        }
        int allSum =mArray[0]+mArray[1]+mArray[2];

       for ( int i = 0;i<mArray.length-(m-1);i++){
           int sum = 0;
            for (int j = i;j<m+i&&j<mArray.length;j++) {
                sum +=mArray[j];
            }

           allSum = Math.min(sum,allSum);
       }
        System.out.println(allSum);
    }

}
