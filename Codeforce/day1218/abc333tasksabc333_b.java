//package Codeforce.day1218;//package Codeforce.day1218;
//
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//
//public class abc333tasksabc333_b {
//
//    public static void main(String[] args) {
//        String[] letters = {"A", "B", "C", "D", "E"};
//        Random random = new Random();
//
//        for (int i = 0; i < 10000000; i++) { // Generate 100 pairs of random strings
//            String s1 = letters[random.nextInt(5)] + letters[random.nextInt(5)];
//            String s2 = letters[random.nextInt(5)] + letters[random.nextInt(5)];
//
//            if (!f1(s1, s2).equals(f2(s1, s2))) {
//                System.out.println("Mismatch found for: " + s1 + ", " + s2);
//            }
//        }
//        System.out.println("Done");
//    }
//
//    public  static String f2(String s1,String s2){
//        Map<String, Integer> map = new HashMap<>();
//        map.put("AB",1);
//        map.put("AC",2);
//        map.put("AD",2);
//        map.put("AE",1);
//
//        map.put("BA",1);
//        map.put("BC",1);
//        map.put("BD",2);
//        map.put("BE",2);
//
//        map.put("CA",2);
//        map.put("CB",1);
//        map.put("CD",1);
//        map.put("CE",2);
//
//        map.put("DA",2);
//        map.put("DB",2);
//        map.put("DC",1);
//        map.put("DE",1);
//
//        map.put("EA",1);
//        map.put("EB",2);
//        map.put("EC",2);
//        map.put("ED",1);
//
//        if (map.get(s1)==(map.get(s2))) {
//           return "YES";
//        } else {
//            return "NO";
//        }
//    }
//
//
//
//
//        public static String f1(String s1,String s2) {
//            int x1 = Math.abs(s1.charAt(0) - s1.charAt(1));
//            int x2 = Math.abs(s2.charAt(0) - s2.charAt(1));
//            if (x1 > 2) x1 = 5 - x1;
//            if (x2 > 2) x2 = 5 - x2;
//            if (x1 == x2) {
//               return "YES";
//            } else {
//                return "NO";
//            }
//        }
//
//}




package Codeforce.day1218;//package Codeforce.day1218;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//
///**
// * 功能：
// * 日期：2023/12/18 20:30
// */
//public class abc333tasksabc333_b {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s1 = sc.next();
//        String s2 = sc.next();
//        char[][] a = new char[2][2];
//        // 填
//        a[0] = s1.toCharArray();
//        a[1] = s2.toCharArray();
//       int x1 = Math.abs(a[0][0]-a[0][1]);
//        int x2 = Math.abs(a[1][0]-a[1][1]);
//        if (x1==x2){
//            System.out.println("YES");
//        }
//        else if (x1==4&& x2==1||x2==4&& x1==1){
//            System.out.println("YES");
//        }
//        else if (x1==2&&x2==3||x1==3&&x2==2){
//            System.out.println("YES");
//        }
//        else {
//            System.out.println("NO");
//        }
//    }
//}


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
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class abc333tasksabc333_b {
    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintStream out = new PrintStream(System.out);
        String s1 = in.next();
        String s2 = in.next();
        Map<String, Integer> map = new HashMap<>();
        map.put("AA",1);
        map.put("AB",1);
        map.put("AC",2);
        map.put("AD",2);
        map.put("AE",1);

        map.put("BA",1);
        map.put("BB",1);
        map.put("BC",1);
        map.put("BD",2);
        map.put("BE",2);

        map.put("CA",2);
        map.put("CB",1);
        map.put("CD",1);
        map.put("CE",2);
        map.put("CC",1);

        map.put("DA",2);
        map.put("DB",2);
        map.put("DC",1);
        map.put("DE",1);
        map.put("DD",1);

        map.put("EA",1);
        map.put("EB",2);
        map.put("EC",2);
        map.put("ED",1);
        map.put("EE",1);

        if (map.get(s1)==(map.get(s2))) {
           out.println("YES");
        } else {
           out.println("NO");
        }

    }
}





class  QuickInput
{
    BufferedReader buf;
    StringTokenizer tok;
     QuickInput(){
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    boolean hasNext(){
        while(tok == null || !tok.hasMoreElements()){
            try{
                tok = new StringTokenizer(buf.readLine());
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
    String next(){
        if(hasNext()) return tok.nextToken();
        return null;
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    BigInteger nextBigInteger(){
        return new BigInteger(next());
    }
    BigDecimal nextBigDecimal(){
        return new BigDecimal(next());
    }
}
