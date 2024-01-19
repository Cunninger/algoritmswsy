package camp05;

import java.util.HashMap;

public class Code06_LongestNoRepeatSubstring {
//    public static int maxUnique(String s) {
//
//        if (s == null || s.length() == 0) return 0;
//        char[] str = s.toCharArray();
//        int len = 0;
//        int pre = -1;
//        int[] dp = new int[str.length];
//        HashMap<Character, Integer> map = new HashMap<>();// key:字符，value:字符上一次出现的位置
//        for (int i = 0; i < str.length; i++) {
//            char ch = str[i];
//            if (!map.containsKey(ch)) {
//                dp[i] = pre == -1 ? 1 : dp[pre] + 1;//  dp[i] = pre==-1?1:dp[pre]+1;  说明pre位置的字符没有出现过
//            }
//            if (pre == -1) {
//                dp[i] = i + 1;
//            } else {
//                dp[i] = i - pre;
//            }
//
//            len = Math.max(len, dp[i]);
//            map.put(ch, i);
//
//
//        }
//        return len;
public static int maxUnique(String str) {
    if (str == null || str.equals("")) {
        return 0;
    }
    char[] chas = str.toCharArray();
    // map 替代了哈希表   假设字符的码是0~255
    int[] map = new int[256];
    for (int i = 0; i < 256; i++) {
        map[i] = -1;
    }
    int len = 0;
    int pre = -1;
    int cur = 0;
    for (int i = 0; i != chas.length; i++) {
        pre = Math.max(pre, map[chas[i]]);
        cur = i - pre;
        len = Math.max(len, cur);
        map[chas[i]] = i;
    }
    return len;
}

    public static int maxUnique2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int n = str.length();
        int[] dp = new int[n];
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        int pre = -1; // The starting index of the current substring
        dp[0] = 1;
        charIndexMap.put(str.charAt(0), 0);

        for (int i = 1; i < n; i++) {
            char c = str.charAt(i);

            // If character is already seen, update pre
            if (charIndexMap.containsKey(c)) {
                pre = Math.max(pre, charIndexMap.get(c));
            }
            // 假如i位置是a。pre是最近的a的位置，i-pre是a的距离
            // pre+1到i-1如果有重复的，

            dp[i] = i - pre;     // pre 是最近的瓶颈
            charIndexMap.put(c, i);
        }

        // Finding the max value in dp
        int maxLength = 0;
        for (int val : dp) {
            maxLength = Math.max(maxLength, val);
        }

        return maxLength;
    }





    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(maxUnique(s));
        System.out.println(maxUnique2(s));

    }
}
