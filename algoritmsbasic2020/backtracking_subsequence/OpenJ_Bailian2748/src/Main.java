import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main{
    static boolean []used;
    static char[]str;
    public static void main(String[] args){
         QuickInput in = new  QuickInput();
        PrintWriter out = new PrintWriter(System.out);

        //in.nextInt().....
        //out.println().....
        String s = in.nextLine();
        str = s.toCharArray();
        used = new boolean[s.length()];
        List<String> list = new ArrayList<>();
        List<List<String>> path = new ArrayList<>();
        dfs(0,list,path);
        // 生成全排列


//        for (List<String> uu : path) {  // 遍历外层列表
//            for (String str : uu) {     // 遍历内层列表
//                out.printf("%5s",str);
//            }
//
//            out.println();
//        }
        for (int i = 0;i<path.size();i++){
            List<String> temp = path.get(i);
            for (int j = 0; j <temp.size() ; j++) {
                out.print(temp.get(j));
            }
            if (i!=path.size()-1){
                out.println();
            }
        }

        out.close();
        // 一定要关流;
    }

    public static void dfs(int index,List<String> list, List<List<String>> path ){
        if (list.size()==str.length){
            path.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0;i<str.length;i++){
            if (!used[i]){
                used[i]=true;
                list.add(String.valueOf(str[i]));
                dfs(index+1,list,path);
                used[i]=false;
                list.remove(list.size()-1);
            }
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
