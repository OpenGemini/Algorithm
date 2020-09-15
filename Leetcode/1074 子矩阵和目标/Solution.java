/**
 * Given a matrix, and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
 *
 * Example 1:
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 *
 * Example 2:
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 *
 * Example 3:
 * Input: matrix = [[904]], target = 0
 * Output: 0
 *  
 *
 * Constraints:
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 *
 * 解题思路
 *
 * | 1 2 3 |               |0  0  0   0 |
 * | 4 5 6 |  => columnSum |0  1  3   6 | => 求 5,6,8,9的子矩阵和 = 45 -12 -6 + 1
 * | 7 8 9 |               |0  5  12  21|
 *                         |0  12 27  45|
 */
import java.util.*;
class Solution {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return 0;
        }
        int count  = 0;
        int m = matrix.length + 1;
        int n = matrix[0].length + 1;
        int[][] columnSum = new int[m][n];
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                columnSum[i][j] = columnSum[i - 1][j] + columnSum[i][j - 1] - columnSum[i - 1][j - 1] + matrix[i-1][j-1];
            }
        }

        for (int [] r1:columnSum) {
            System.out.println(Arrays.toString(r1));
        }
        System.out.println("=======================");

        int subMatrixSum = 0;
        // 确认四个点获取到矩阵
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                for (int startX = 1; startX <= i; startX++)
                    for (int startY = 1; startY <= j; startY++) {
                        /**
                         *  | 1 2 3 |               |0  0  0   0 |
                         *  | 4 5 6 |  => columnSum |0  1  3   6 | => 求 5,6,8,9的子矩阵和 = 45 -12 -6 + 1
                         *  | 7 8 9 |               |0  5  12  21|
                         *                          |0  12 27  45|
                         */
                        if (columnSum[i][j] - columnSum[i][startY - 1] - columnSum[startX - 1][j] + columnSum[startX - 1][startY - 1] == target)
                            count++;
                    }
        return count;
    }

    public static void main(String args[]) {
        int[][] arr1 = new int[][] {{1,2,3,},{4,5,6,},{7,8,9}};
        int[][] arr2 = new int[][] {{1, -1},{-1,1}};
        int[][] arr3 = new int[][] {{9,0,4}};
        int[][] arr4 = new int[][] {{1,1,1,1},{1,9,10,1},{0,1,1,1},{1,1,1,1}};
        int res1 = numSubmatrixSumTarget(arr1, 7);
        int res2 = numSubmatrixSumTarget(arr2, 0);
        int res3 = numSubmatrixSumTarget(arr3, 0);
        int res4 = numSubmatrixSumTarget(arr4, 19);
        System.out.println(res1);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}