package  PTA;

import java.io.PrintWriter;

public class test09{
    public static void main(String[] args){
        QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int T = in.nextInt();

        int fenzi = 0;
        int sum = 1;
        int fenmu =1;
        String s = in.nextLine();

        String s1[] = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            String s2[] = s1[i].split("/");
            fenmu *= Integer.valueOf(s2[1]);
        }
        // 分母总和计算完
        for (int i = 0; i < s1.length; i++) {
            String s2[] = s1[i].split("/");
            fenzi += (fenmu/Integer.valueOf(s2[1]))*Integer.valueOf(s2[0]);
        }



        int gg = gcd(fenzi,fenmu);
        fenzi/=gg;
        fenmu/=gg;


        if (fenzi>fenmu){
            if (fenmu==1){
                out.println(fenzi);

            }
            else{
                out.println(fenzi/fenmu+" "+fenzi%fenmu+"/"+fenmu);
            }
        }
        else if(fenzi==fenmu){
            out.println("1");
        }
        else{
            out.println(fenzi+"/"+fenmu);
        }





        out.close();
        // 一定要关流;
    }

    public static int gcd(int a,int b){

        return b==0?a:gcd(b,a%b);
    }

}


