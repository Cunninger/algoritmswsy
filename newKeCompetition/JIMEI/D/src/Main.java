import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    static int maxSum = 0;
    static  int[][]mat = new int[13][13];
    public static void main(String[] args) throws Exception{

        long startTime = System.currentTimeMillis();

        File file = new File("newKeCompetition/JIMEI/D/src/in.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int row = 0;
        while ((line=br.readLine())!=null){
            String[]num = line.split(" ");
            for (int col = 0;col<num.length;col++){
                mat[row][col] = Integer.parseInt(num[col]);
            }
            row++;
        }
        int currentSum = 0;
        boolean []used = new boolean[mat[0].length];
        backtracking(0,used,currentSum);
        System.out.println(maxSum);

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in milliseconds: " + timeElapsed/1000.0);
    }

    static void backtracking(int row ,boolean[]used,int currentSum){
        if (row==mat.length){
            maxSum= Math.max(maxSum,currentSum);

            return;
        }

        for (int col = 0;col<mat[0].length;col++){
            if (!used[col]){
                used[col] = true;
                backtracking(row+1,used,currentSum+mat[row][col]);
                used[col] = false;
            }
        }
    }
}