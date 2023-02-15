package FindLargestSquareInMatrix;
//Time complexity of below method : O(m)(n) - single pass
//Space complexity : O(mn)- Another matrix of same size is used for dp.

public class getLargestSquareLC {

    private static int findMaxSquareLength(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1]; //+1 for bottom right corner of the DP
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        System.out.println("The maximum matrix of 1's has size:" + maxsqlen * maxsqlen);
        return maxsqlen * maxsqlen;
    }


    // Driver program
    public static void main(String[] args) {
        char M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        findMaxSquareLength(M);
    }


}
