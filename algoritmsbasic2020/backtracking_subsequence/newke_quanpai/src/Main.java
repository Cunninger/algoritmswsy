import java.util.*;

public class Main{
    static  int[]arr =new int []{1,2,3,4,5,6,7,8};
    public static void main(String[]args){

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(temp,0,ans);
        for (List<Integer> list : ans) {
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    System.out.print(list.get(i) + " ");
                } else {
                    System.out.println(list.get(i));
                }
            }
        }
    }

    public static void backtracking(List<Integer> temp,int idx,List<List<Integer>>ans){
        if (idx == arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = idx;j<arr.length;j++){
            swap(arr,idx,j);
            temp.add(arr[idx]);
            backtracking(temp,idx+1,ans);
            swap(arr,idx,j);
            temp.remove(temp.size() - 1);
        }
    }

    public static void swap(int[]arr,int x, int j){
        int temp = arr[x];
        arr[x] = arr[j];
        arr[j] = temp;
    }
}
