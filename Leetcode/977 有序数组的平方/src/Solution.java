/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
import java.util.*;
class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] best(int[] A) {
        int [] ans = new int[A.length];
        int begin = 0;
        int end = A.length - 1;
        int index = A.length - 1;
        while (begin <= end) {
            if (A[begin] * A[begin] <= A[end] * A[end]) {
                ans[index] = A[end] * A[end];
                end--;
                index--;
            } else {
                ans[index] = A[begin] * A[begin];
                begin++;
                index--;
            }
        }
        return ans;
    }

    public int[] doublePoint(int[] A) {
        int n = A.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] s1 = new int[] {-7,-3,2,3,11};
        int [] s2 = new int[] {4,9,9,49,121};
        int[] r1 = solution.best(s1);
        int[] r2 = solution.best(s2);
        System.out.println(Arrays.toString(r1));
        System.out.println(Arrays.toString(r2));
    }
}