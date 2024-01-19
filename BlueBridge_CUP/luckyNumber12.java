package BlueBridge_CUP;

import java.util.stream.IntStream;

public class luckyNumber12 {
    public static void main(String[] args) {
        final int range = (int) 1e9;
        long cnt = IntStream.rangeClosed(1, range).parallel().filter(i -> {
            String s = Integer.toString(i);
            int[] arr = new int[s.length()];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = s.charAt(j) - '0';
            }
            int len = s.length();
            if (len % 2 == 0) {
                int sum1 = 0;
                int sum2 = 0;
                int k = 0;
                for (; k < len / 2; k++) {
                    sum1 += arr[k];
                }
                for (; k < s.length(); k++) {
                    sum2 += arr[k];
                }
                return sum1 == sum2;
            }
            return false;
        }).count();

        System.out.print(cnt);
    }
}