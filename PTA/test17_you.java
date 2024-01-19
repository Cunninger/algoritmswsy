package PTA;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 功能：
 * 日期：2024/1/18 9:10
 */
public class test17_you {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        BigDecimal degreeOfTwo = calculateDegreeOfTwo(input);//解释
        // java实现红黑树


        System.out.printf("%.2f%%", degreeOfTwo);

    }

    private static BigDecimal calculateDegreeOfTwo(String number) {
        BigDecimal countOfTwo = new BigDecimal(0);
        BigDecimal length = new BigDecimal(number.length());
        BigDecimal multiplier = new BigDecimal(1);
        if (number.charAt(0) == '-') {
            multiplier = multiplier.multiply(new BigDecimal(1.5));
            length = length.subtract(BigDecimal.ONE);// 减去负号的位数
        }


        for (char digit : number.toCharArray()) {
            if (digit == '2') {

                countOfTwo = countOfTwo.add(BigDecimal.ONE);

            }
        }

        if (new BigDecimal(number).remainder(new BigDecimal(2)).equals(BigDecimal.ZERO)) {
            multiplier = multiplier.multiply(new BigDecimal(2));

        }

        return countOfTwo.divide(length, 5, BigDecimal.ROUND_HALF_UP).multiply(multiplier).multiply(new BigDecimal(100));

    }
}