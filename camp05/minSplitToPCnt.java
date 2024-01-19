package camp05;

public class minSplitToPCnt {


    public static int process(String s, int i) {
        if (s == null || s.length() == 0) return 0;
        if (i == s.length()) return 0;

        char[] str = s.toCharArray();

        int ans = Integer.MAX_VALUE;
        for (int end = i; end < str.length; end++) {
            if (isVaild(str, i, end)) {
                ans = Math.min(1 + process(s, end + 1), ans);
            }
        }
        return ans;
    }

    public static boolean isVaild(char[] str, int start, int end) {

        for (int i = start, j = end; i < j; i++, j--) {
            if (str[i] != str[j]) {
                return false;
            }
        }


        return true;
    }

    // dp 优化版本 利用范围尝试模型 加速 isVaild()判断过程

    public static int process2(String s, int i) {
        if (s == null || s.isEmpty()) return 0;
        int N = s.length();
        char[] str = s.toCharArray();
        boolean[][] isValid2 = new boolean[N][N];
        // 定义：str[i.....j] 上是否为回文串
        for (int t = 0; t < N; t++) {
            isValid2[t][t] = true;
        }
        for (int row = N - 2; row >= 0; row--) {
            isValid2[row][row + 1] = str[row] == str[row + 1];
        }

        for (int row = N - 3; row >= 0; row--) {
            for (int col = row + 1; col < N; col++) {
                isValid2[row][col] = str[row]==str[col] && isValid2[row+1][col-1];//str[row]==str[col]!!!
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int end = i; end < str.length; end++) {
            if (isValid2[i][end]) {
                ans = Math.min(1 + process(s, end + 1), ans);
            }
        }
        return ans;



    }


    public static void main(String[] args) {
        String s = "abaKDKUUIUDUW";
        System.out.println(process(s, 0));
        System.out.println(process2(s, 0));

    }
}
