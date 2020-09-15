/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 * Example 2:
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 */
import java.util.*;
class TransposeMatrix {
    public static int[][] transpose(int[][] A) {
        int[][] Res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                Res[j][i] = A[i][j];
            }
        }
        return Res;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int[][] test2 = new int[][] {{1,2,3},{4,5,6}};
        int[][] res1 = transpose(test1);
        int[][] res2 = transpose(test2);
        for (int[] r1 : res1) {
            System.out.println(Arrays.toString(r1));
        }
        for (int[] r2 : res2) {
            System.out.println(Arrays.toString(r2));
        }
    }
}