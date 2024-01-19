package newKeCompetition.JIMEI;

public class MaxSum {
    static int[][] matrix = {
            {231, 1338, 1542, 581, 724, 459, 1895, 382, 118, 1919, 1556, 1216, 412},
            {842, 1181, 1552, 344, 1716, 1256, 265, 210, 490, 1486, 1641, 518, 138},
            {1212, 178, 785, 1435, 868, 634, 1560, 1715, 1785, 1339, 65, 351, 1366},
            {516, 231, 606, 520, 70, 122, 1222, 1135, 1847, 701, 718, 753, 1810},
            {183, 290, 647, 1030, 914, 755, 543, 931, 1871, 1780, 1096, 704, 752},
            {1502, 1561, 1543, 1581, 237, 826, 311, 784, 1616, 712, 1138, 841, 1245},
            {678, 396, 1530, 1386, 71, 1330, 1211, 85, 1221, 976, 759, 814, 1837},
            {1978, 222, 392, 1457, 948, 1793, 1339, 20, 602, 1017, 1333, 529, 633},
            {1825, 388, 1589, 1860, 39, 1357, 817, 368, 463, 1577, 217, 568, 1808},
            {1379, 711, 25, 949, 1147, 1864, 1719, 109, 1013, 1278, 1911, 1771, 1211},
            {572, 1315, 262, 1575, 1885, 1753, 1210, 826, 1886, 876, 118, 216, 224},
            {914, 1708, 137, 135, 372, 1861, 1162, 365, 145, 1962, 1594, 239, 1131},
            {204, 1214, 1151, 440, 1468, 1373, 1616, 1634, 1651, 1988, 686, 1672, 1340}
    };
    static int maxSum = 0;

    public static void main(String[] args) {
        boolean[] used = new boolean[matrix.length];
        calculateSum(0, 0, used);
        System.out.println(maxSum);
    }

    private static void calculateSum(int row, int currentSum, boolean[] used) {
        if (row == matrix.length) {
            maxSum = Math.max(maxSum, currentSum);
            return;
        }
        for (int col = 0; col < matrix.length; col++) {
            if (!used[col]) {
                used[col] = true;
                calculateSum(row + 1, currentSum + matrix[row][col], used);
                used[col] = false;
            }
        }
    }
}