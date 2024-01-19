package leetcode_daily.monotonicStack;

import java.util.Stack;

public class leftAndRightMostBiggerNumber_revoke {
    public static  int[][]getNearLessNoRepeat(int []arr){
        int [][]res = new int[arr.length][2];

        Stack<Integer> stack = new Stack<>();


        for (int i = 0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                // 栈不为空，且栈顶元素大于当前元素

                // 开始弹出，即结算栈顶元素的答案

                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty()?-1:stack.peek();
                int rightLessIndex = i;
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = rightLessIndex;

            }
            stack.push(i);
        }

        // 遍历结束，开始清算栈中所有元素，rightLessIndex = -1，右边没有比其更大的元素了
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty()?-1:stack.peek();
            int rightLessIndex = -1;
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = rightLessIndex;

        }
        return  res;
    }

}
