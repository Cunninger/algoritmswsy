import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int sum = scanner.nextInt();
            System.out.println(findMinimalWord(sum));
        }
        scanner.close();
    }

    public static String findMinimalWord(int sum) {
        String minWord = "zzz";
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    if (i-'a' + j-'a' + k-'a'+3 == sum) {
                        String cur = String.valueOf(i)+String.valueOf(j)+String.valueOf(k);
                        if (cur.compareTo(minWord) < 0) {
                            minWord = cur;
                        }
                    }
                }
            }
        }
        return minWord;
    }
}

//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.*;
//
//public class Main{
//    public static void main(String[] args){
//         QuickInput in = new  QuickInput();
//        PrintWriter out = new PrintWriter(System.out);
//        char a = 'a';
//        char b = 'b';
//        String s = ""+a+b;
//        out.println(s);
//
//        out.close();
//
//    }
//}
//
//
//class  QuickInput
//{
//    BufferedReader buf;
//    StringTokenizer tok;
//     QuickInput(){
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
