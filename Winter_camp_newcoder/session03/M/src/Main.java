import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Map<Integer, Integer> countLastDigit = new HashMap<>();
        Map<Integer, Integer> countSumMod9 = new HashMap<>();

        // 预处理每个数的最后一位和数位和mod 9的结果
        for (int i = 0; i < N; i++) {
            long number = scanner.nextLong();

            int lastDigit = (int)(number % 10);
            int sumMod9 = 0;
            while (number > 0) {
                sumMod9 += (number % 10);
                number /= 10;
            }
            sumMod9 %= 9;

            // 更新最后一位的计数
            countLastDigit.put(lastDigit, countLastDigit.getOrDefault(lastDigit, 0) + 1);
            // 更新数位和mod 9的计数
            countSumMod9.put(sumMod9, countSumMod9.getOrDefault(sumMod9, 0) + 1);
        }

        long count = 0;
        // 组合计算数对数量
        for (int i = 0; i < 10; i++) {
            if (countLastDigit.containsKey(i)) {
                for (int j = 0; j < 10; j++) {
                    if (i != j && countLastDigit.containsKey(j)) {
                        // 检查拼接后的最后两位能否被4整除
                        if ((i * 10 + j) % 4 == 0) {
                            for (int sum1 = 0; sum1 < 9; sum1++) {
                                int sum2 = (9 - sum1) % 9;
                                // 检查拼接后的数位和能否被9整除
                                if (countSumMod9.containsKey(sum1) && countSumMod9.containsKey(sum2)) {
                                    // 乘以组合计数
                                    count += (long)countSumMod9.get(sum1) * countSumMod9.get(sum2);
                                    if (sum1 == sum2) {
                                        // 减去重复计数
                                        count -= countSumMod9.get(sum1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count / 2); // 除以2是因为每个数对计算了两次
        scanner.close();
    }
}