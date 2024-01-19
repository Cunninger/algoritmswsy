package leetcode_daily;
import java.util.ArrayList;
import java.util.Arrays;

public class minSpiltTwoSum {

        public int splitNum(int num) {
            // 枚举所有分割取最小
            int allMax = Integer.MAX_VALUE;
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            int[] numArray = String.valueOf(num).chars().map(Character::getNumericValue).toArray();
            Arrays.sort(numArray);
            for (int i = 0;i<numArray.length-1;i+=2){
                list1.add(numArray[i]);
                list2.add(numArray[i+1]);
                if (i+2==numArray.length)break;
            }

            int n1 = list1.size();
            int n2 = list2.size();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0;i<n1;i++){
                sum1+=(list1.get(i))*(10^(n1-i-1));
            }
            for (int i = 0;i<n2;i++){
                sum2 += (list2.get(i))*(10^(n2-i-1));
            }

            return sum1+sum2;



        }

    public static void main(String[] args) {
        minSpiltTwoSum msts = new minSpiltTwoSum();
        System.out.println(msts.splitNum(123456));
    }
    }
