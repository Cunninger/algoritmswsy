package camp05;

/**
 * 【题目】
 * 给定一个只由 0（假）、1（真）、&（逻辑与）、|（逻辑或）和^（异或）五种字符组成的字
 * 符串 express，再给定一个布尔值 desired。返回 express 能有多少种组合方式，可以达到 desired
 * 的结果。
 */
public class expressionWantValue {
    public int num1(String express, boolean disired) {
        if (express == null || express.length() == 0) {
            return 0;
        }
        char[] str = express.toCharArray();
        if (!isValid(str)) {
            return 0;
        }
        return p(str, disired, 0, str.length - 1);
    }

    public boolean isValid(char[] str) {
        if (str.length % 2 == 0) {
            return false;
        }

        for (int i = 0; i < str.length; i += 2) {
            // 奇数位必须是0或1
            if (str[i] != '0' && str[i] != '1') {
                return false;
            }

        }

        for (int i = 1; i < str.length; i += 2) {
            // 偶数位必须是& | ^
            if (str[i] != '&' && str[i] != '|' && str[i] != '^') {
                return false;
            }
        }
        return true;
    }

    public int p(char[] exp, boolean disired, int l, int r) {
        // base case
        if (l == r) {
            if (exp[l] == '1') {
                return disired ? 1 : 0;
            }                               // 如果期待的结果是true，那么只有当exp[l] == '1'时，才返回1，否则返回0
            else {
                return disired ? 0 : 1;
            }
        }

        int res = 0;
        if (disired) {                   // 期待的结果是true
            for (int i = l + 1; i < r; i += 2) { // i 代表运算符的位置
                switch (exp[i]) {
                    case '&':           // 如果运算符是&，那么只有当左右两边都是true时，才返回1
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        break;
                    case '|':
                        res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
                        res += p(exp,true,l,i-1)*p(exp,false,i+1,r);
                        res += p(exp,false,l,i-1)*p(exp,true,i+1,r);
                        break;
                    case '^':
                        res += p(exp,true,l,i-1)*p(exp,false,i+1,r);
                        res += p(exp,false,l,i-1)*p(exp,true,i+1,r);
                }

            }
        }
        else{
            for (int i = l + 1; i < r; i += 2) { // i 代表运算符的位置
                switch (exp[i]) {
                    case '&':           // 如果运算符是&，那么只有当左右两边都是true时，才返回1
                        res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
                        res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);

                        res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
                        break;
                    case '|':
                        res += p(exp,false,l,i-1)*p(exp,false,i+1,r);
                        break;
                    case '^':
                        res += p(exp,true,l,i-1)*p(exp,true,i+1,r);
                        res += p(exp,false,l,i-1)*p(exp,false,i+1,r);
                }

            }
        }
        return  res;

    }

    public static void main(String[] args) {
        expressionWantValue ewv = new expressionWantValue();
        System.out.println(ewv.num1("1^0|0|1", false));// 2
    }

}
