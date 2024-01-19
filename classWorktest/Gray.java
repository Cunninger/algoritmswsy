package classWorktest;
import java.util.*;
public class Gray {

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getGray(n));
    }

    public static List<String> getGray(int n){
        // base case
        if (n==1)
        {
            List<String> base = new ArrayList<>();
            //StringBuilder sb = new StringBuilder();
            base.add("0");
            base.add("1");
            return base;

        }
        List<String> prev = getGray(n-1);// n-1
        //StringBuilder prevSb = getGray(n-1);

        List<String> newGray = new ArrayList<>();

        //for (int i = 0;i<prevSb.length();)
        for (String x:prev){
            newGray.add("0"+x);
        }

        for (int i = prev.size()-1;i>=0;i--){
            newGray.add("1"+prev.get(i));
        }



        return  newGray;
    }

}
