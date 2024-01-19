package camp05;

public class expressionWantValue_dp {
    public static int num(String s,boolean desired){
        char[] str = s.toCharArray();
        if (!isValid(str))return 0;
        int N = str.length;
        int [][]t = new int[str.length][str.length];
        int [][]f = new int[str.length][str.length];

        // base case
        for (int i = 0;i<N;i+=2){
            t[i][i] = str[i] == '1' ? 1 : 0;  // t[i][i] 表示str[i..i]范围上，期待的结果是1，能有多少种组合方式
            f[i][i] = str[i] == '0' ? 1 : 0;

        }

        // 从下往上，从左往右填表

        for (int i = N-3;i>=0;i-=2){
          for (int j = i+2;j<N;j+=2){
              // 前面两个循环 跳过所有不需要填的位置

              for (int k = i+1;k<j;k+=2){  // 枚举每一个符号位置

                  // 可以把 i 理解为左边界，j 理解为右边界  k理解为运算符位置。

                  switch (str[k]){
                      case '&':
                          t[i][j] += t[i][k-1] * t[k+1][j];
                          break;
                      case '|':
                          t[i][j] +=t[i][k-1] * t[k+1][j] + t[i][k-1] * f[k+1][j] + f[i][k-1] * t[k+1][j];


                          break;
                      case '^':
                          t[i][j] += t[i][k-1] * f[k+1][j] + f[i][k-1] * t[k+1][j];
                          break;
                  }
                  switch (str[k]){
                      case '&':
                          f[i][j] += f[i][k-1] * f[k+1][j] + t[i][k-1] * f[k+1][j] + f[i][k-1] * t[k+1][j];
                            break;
                      case '|':
                          f[i][j] += f[i][k-1] * f[k+1][j];
                            break;
                      case '^':
                           f[i][j] += t[i][k-1] * t[k+1][j] + f[i][k-1] * f[k+1][j];
                            break;
                  }
              }


        }

    }
        return desired ? t[0][N-1] : f[0][N-1];

    }

    public static boolean isValid(char[]str){
        if (str.length % 2 == 0){
            return false;
        }

        for (int i = 0;i<str.length;i+=2){
            if (str[i] != '0' && str[i] != '1'){
                return false;
            }
        }

        for (int i = 1;i< str.length;i+=2){
            if (str[i] != '&' && str[i] != '|' && str[i] != '^'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String exp = "1^0|0|1";
        boolean desired = false;
        System.out.println(num(exp,desired));// 2
    }
}
