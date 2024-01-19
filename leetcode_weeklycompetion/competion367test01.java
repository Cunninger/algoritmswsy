package leetcode_weeklycompetion;

public class competion367test01 {

        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            int maxIdx = 0,minIdx = 0;

            for (int j = indexDifference;j<nums.length;j++){
                int i = j-indexDifference;
                if (nums[i] > nums[maxIdx]){
                    maxIdx = i;
                }else if (nums[i] < nums[minIdx]){
                    minIdx = i;
                }

                if (nums[maxIdx] - nums[j] >= valueDifference){
                    return new int[]{maxIdx,j};
                }
                if (nums[j]-nums[minIdx] >= valueDifference){
                    return new int []{minIdx,j};
                }



            }
            return new int[]{-1,-1};
  


        }

    public static void main(String[] args) {
        int []nums = {5,1,4,1};
        int indexDifference = 2;
        int valueDifference = 4;
        competion367test01 test = new competion367test01();
        int []res = test.findIndices(nums,indexDifference,valueDifference);
        for (int i:res){
            System.out.println(i);
        }
    }


    }
