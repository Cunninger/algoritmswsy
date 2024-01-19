package classWorktest;

public class processToMinInArray {
    public static int process(int[]array,int i){
        // 求 从 i....array.length 最小值

        if (i >= array.length)return Integer.MAX_VALUE;
        if (i== array.length-2)return Math.min(array[array.length-1],array[array.length-2]);

        return Math.min(array[i],process(array,i+1));

    }

    public static void main(String[] args) {
        int []array = {1,2,4,2,4,-86,0};
        System.out.println(process(array,0));
    }
}
