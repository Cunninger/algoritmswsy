package PTA;

import java.io.PrintWriter;

public class test16{
    public static void main(String[] args){
         QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        //in.nextInt().....
        //out.println().....

        int T = in.nextInt();

        char[]yz = {'1','0','X','9','8','7','6','5','4','3','2','1'};
        int []w =  {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int count = 0;// 判断是否flag，count==0输出All passed
        while (T-->0){
            int sum = 0;// 计算权值 的
            boolean flag = false;// 用来是否标记成功的
            String s= in.nextLine();
            for (int i = 0;i<17;i++){
                if(s.charAt(i)=='X'||s.charAt(i)=='x'){
                    flag = true;
                }
                else{
                    sum+= (s.charAt(i)-'0')*w[i];
                }
            }


            if (yz[sum%11]!=s.charAt(17)){
                flag= true;
            }

            if (flag){
                System.out.println(s);
                count++;
            }

            if (count==0){
                System.out.println("All passed");
            }
        }


        out.close();
        // 一定要关流;
    }

}

