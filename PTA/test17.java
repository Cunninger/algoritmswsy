package PTA;

/**
 * 功能：
 * 日期：2024/1/18 8:54
 */

import java.io.PrintWriter;

public class test17{
    public static void main(String[] args){
        QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        String s = in.next();

        char[]str = s.toCharArray();

        int cnt = 0;
        for (int i = 0;i<str.length;i++){
            if (str[i]=='2'){
                cnt++;
            }

        }
        double sum = 1.00;
        if (str[0]=='-'){
            if (str[str.length-1]%2==0){
                sum=  ((double)cnt/(str.length-1)*1.5*2*100);
            }
            else{
                sum=  ((double)cnt/(str.length-1)*1.5*100);
            }

        }
        else{
            if (str[str.length-1]%2==0){
                sum=((double)cnt/(str.length-1)*2*100);
            }
            else{
                sum=((double)cnt/(str.length-1)*100);
            }
        }
        out.printf("%.2f",sum);
        out.print("%");

        out.close();
        // 一定要关流;
    }
}

//
//class  QuickInput
//{
//    BufferedReader buf;
//    StringTokenizer tok;
//    QuickInput(){
//        buf = new BufferedReader(new InputStreamReader(System.in));
//    }
//    boolean hasNext(){
//        while(tok == null || !tok.hasMoreElements()){
//            try{
//                tok = new StringTokenizer(buf.readLine());
//            }catch(Exception e){
//                return false;
//            }
//        }
//        return true;
//    }
//    String next(){
//        if(hasNext()) return tok.nextToken();
//        return null;
//    }
//    int nextInt(){
//        return Integer.parseInt(next());
//    }
//    long nextLong(){
//        return Long.parseLong(next());
//    }
//    double nextDouble(){
//        return Double.parseDouble(next());
//    }
//    BigInteger nextBigInteger(){
//        return new BigInteger(next());
//    }
//    BigDecimal nextBigDecimal(){
//        return new BigDecimal(next());
//    }
//    String nextLine() {
//        try {
//            return buf.readLine();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
