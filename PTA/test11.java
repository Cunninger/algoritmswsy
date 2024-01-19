//package PTA;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.StringTokenizer;
//
//public class test11 {
//    public static void main(String[] args) {
//        QuickInput in = new QuickInput();
//        PrintWriter out = new PrintWriter(System.out);
//        String s1 = in.nextLine();
//        String s2 = in.nextLine();
//
//        Set<Character>set = new HashSet<>();
//        for (char s :s2.toCharArray()){
//            set.add(s);
//        }
//       StringBuilder sb = new StringBuilder();
//        for (char s:s1.toCharArray()){
//            if (!set.contains(s)){
//                sb.append(String.valueOf(s));
//            }
//        }
//
//
//        out.print(sb.toString());
//        out.close();
//    }
//}
//
//
//class QuickInput {
//    BufferedReader buf;
//    StringTokenizer tok;
//
//    QuickInput() {
//        buf = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    boolean hasNext() {
//        while (tok == null || !tok.hasMoreElements()) {
//            try {
//                tok = new StringTokenizer(buf.readLine());
//            } catch (Exception e) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    String next() {
//        if (hasNext()) return tok.nextToken();
//        return null;
//    }
//
//    int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    long nextLong() {
//        return Long.parseLong(next());
//    }
//
//    double nextDouble() {
//        return Double.parseDouble(next());
//    }
//
//    BigInteger nextBigInteger() {
//        return new BigInteger(next());
//    }
//
//    BigDecimal nextBigDecimal() {
//        return new BigDecimal(next());
//    }
//
//    String nextLine() {
//        try {
//            return buf.readLine();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
//
//import BufferedReader;
//import InputStreamReader;
//import PrintWriter;
//import BigDecimal;
//import BigInteger;
//import StringTokenizer;
//
//public class Main{
//    public static void main(String[] args){
//         QuickInput in = new  QuickInput();
//        PrintWriter out = new PrintWriter(System.out);
//
//        //in.nextInt().....
//        //out.println().....
//
//        out.close();
//        // 一定要关流;
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
