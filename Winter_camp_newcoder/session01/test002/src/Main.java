import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine().trim());
        while (T-->0) {
            int n = Integer.parseInt(reader.readLine().trim());
            writer.println(calculateLeftmostValues(n));
        }
        writer.flush();
    }

    private static int calculateLeftmostValues(int n) {
        // 初始显示 A 到 F，所以最左侧的题目可以是 A
        // 每次向右，最左侧题目变成下一个六题组的第一题
        int totalValues = 1; // 至少有一个值，即A
        int remaining = n - 6; // 初始情况下去除显示的六道题目后剩下的题目数
        while (remaining > 6) {
            totalValues++; // 如果剩余题目数超过6，则有新的最左侧可能值
            remaining -= 6;
        }
        // 处理最后剩下的题目
        // 剩余题目不足6道，最左侧题目会被重新计算
        if (remaining > 0) {
            totalValues++; // 剩下的题目也会产生一个新的最左侧可能值
        }
        return totalValues;
    }
}