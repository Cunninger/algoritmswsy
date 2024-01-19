package PTA;
import java.util.*;
import java.io.*;
public class test05 {
    public static void main(String[]args){
        QuickInput sc = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        HashMap<String,String> map = new HashMap<>();
        int T = sc.nextInt();

        while (T-->0){
            String s1 = sc.nextLine();
            String ss[] =s1.split(" ");
            map.put(ss[1],ss[0]+"_"+ss[2]);

        }

        int n = sc.nextInt();
        for (int i = 0;i<n;i++){
            int t1 = sc.nextInt();
            String s1 = map.get(String.valueOf(t1)); // Convert t1 to a string
            String []q = s1.split("_");
            out.println(q[0]+" "+q[1]);

        }

        out.close();


    }
}
