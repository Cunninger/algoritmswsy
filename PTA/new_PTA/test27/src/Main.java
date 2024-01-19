import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args){
         QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);


        String s = in.nextLine();
        int []sIntArr = new int[s.length()];
        int qq = 0;
        for (char c :s.toCharArray()){
            sIntArr[qq++] = c-'0';
        }
        Set<Character> set = new HashSet<>();
        for (char c :s.toCharArray()){
            set.add(c);
        }
        Character []cc = set.toArray(new Character[0]);
        Integer []arr = new Integer[set.size()];
        for (int i = 0; i < cc.length; i++) {
            arr[i] = cc[i]-'0';
        }
        Arrays.sort(arr, Collections.reverseOrder());
//        for(Integer c:arr){
//            out.println(c);
//        }
        int[] intArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArray[i] = arr[i];
        }
        int []storage = new int[sIntArr.length];
        for (int i = 0;i<sIntArr.length;i++){
            for (int j = 0;j<intArray.length;j++){
                if (intArray[j]==sIntArr[i]){
                    storage[i] = j;
                    break;
                }
            }
        }
        String ass  =toString1(intArray);


        String bss = toString1(storage);


        out.println("int[] arr = new int[]"+ass +";");
        out.println("int[] index = new int[]"+bss +";");




        out.close();
        // 一定要关流;
    }
    public static String toString1(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(",");
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
    String nextLine() {
        try {
            return buf.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}
