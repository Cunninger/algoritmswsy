import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int MAXN = 10011;
    static int[] father = new int[MAXN];
    static int[] size = new int[MAXN];
    static int[] stack = new int[MAXN];
    static int inf = 0;// build


    public static int find(int i) {
        int size = 0;// 记录沿途节点的个数
        while (i != father[i]) {
            i = father[i];
            stack[size++] = i;
        }
        while (size > 0) {
            father[stack[--size]] = i;
        }
        return i;
    }
    public static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            if (size[fx] > size[fy]) {
                father[fy] = fx;
                size[fx] += size[fy];
            } else {
                father[fx] = fy;
                size[fy] += size[fx];
            }
        }
    }

    public static void main(String[] args) {
        Q in = new Q();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        List<List<Integer>> circles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cnt = in.nextInt();
            List<Integer> circle = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                int a = in.nextInt();
                circle.add(a);
                inf = Math.max(inf, a);
            }
            circles.add(circle);
        }

        for (int i= 1;i<=inf;i++){
            father[i] = i;
            size[i] = 1;
        }



        for (List<Integer> circle:circles){
            int first = circle.get(0);
            for (int i = 1; i < circle.size(); i++) {
                union(first,circle.get(i));

            }

        }
        int cnt =0;
        for (int i = 1; i <= N; i++) {
            if (father[i] == i) { // 如果是根节点
               ++cnt;
            }
        }
        out.print(inf+" "+cnt);
        out.println();

        int query = in.nextInt();
        while (query-->0){
            int o1 = in.nextInt();
            int o2 = in.nextInt();
            if (isSameSet(o1,o2)){
                out.println('Y');
            }
            else {
                out.println('N');
            }
        }

        out.close();

    }

}

class  Q
{
    BufferedReader buf;
    StringTokenizer tok;
    Q(){
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

    String nextLine() {
        try {
            return buf.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}