import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
public class Main {

    static class Qmd {
        double qmd = 0; // 初始化亲密度为0
        int info;

        public Qmd() {
        }

        public Qmd(double q, int i) {
            qmd = q;
            info = i;
        }

    }

    public static void main(String[] args) {
        QuickInput in = new QuickInput();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] photos = new int[M][];
        int A = in.nextInt();
        int B = in.nextInt();
        Map<Integer, Double> intimacyA = new HashMap<>();
        Map<Integer, Double> intimacyB = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int k = in.nextInt();
            photos[i] = new int[k];
            for (int j = 0; j < k; j++) {
                photos[i][j] = in.nextInt();
            }

            // 计算亲密度
            for (int p : photos[i]) {
                if (p != A && p != B) {
                    if (p * A < 0) { // A的异性朋友
                        intimacyA.put(p, intimacyA.getOrDefault(p, 0.0) + 1.0 / k);
                    }
                    if (p * B < 0) { // B的异性朋友
                        intimacyB.put(p, intimacyB.getOrDefault(p, 0.0) + 1.0 / k);
                    }
                }
            }
        }

        // 找出与A亲密度最高的异性朋友
        int bestFriendA = findBestFriend(intimacyA, B);
        // 找出与B亲密度最高的异性朋友
        int bestFriendB = findBestFriend(intimacyB, A);

        // 如果A和B互为最亲密的朋友
        if (bestFriendA == B && bestFriendB == A) {
            out.println(A + " " + B);
        } else {
            if (bestFriendA != Integer.MIN_VALUE) {
                out.println(A + " " + bestFriendA);
            }
            if (bestFriendB != Integer.MIN_VALUE) {
                out.println(B + " " + bestFriendB);
            }
        }

        out.close();
    }

    private static int findBestFriend(Map<Integer, Double> intimacy, int partner) {
        double maxIntimacy = 0;
        int bestFriend = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Double> entry : intimacy.entrySet()) {
            if (entry.getValue() > maxIntimacy || (entry.getValue() == maxIntimacy && entry.getKey() < bestFriend)) {
                maxIntimacy = entry.getValue();
                bestFriend = entry.getKey();
            }
        }
        return bestFriend;
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