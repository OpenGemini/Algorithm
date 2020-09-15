import java.util.*;
class Test {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length][matrix[0].length+1];
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                sum[i][j+1] = sum[i][j] + matrix[i][j];
            }
        }
        int ans = 0;
        int startY = 0, endY = 1;
        int[] lineSum = new int[sum.length+1];
        while(endY < sum[0].length){
            for(; startY < endY; ++startY){
                for(int i = 1; i < lineSum.length; ++i){
                    lineSum[i] = lineSum[i-1] + sum[i-1][endY] - sum[i-1][startY];
                }
                for(int i = 0; i < lineSum.length - 1; ++i){
                    for(int j = i+1; j < lineSum.length; ++j)
                        if(lineSum[j] - lineSum[i] == target)
                            ++ans;
                }
            }
            ++endY;
            startY = 0;
        }
        return ans;
    }

    public static void main(String args[]) {
        int[][] arr1 = new int[][] {{0,1,0,},{1,1,1,},{0,1,0}};
        int[][] arr2 = new int[][] {{1, -1},{-1,1}};
        int[][] arr3 = new int[][] {{9,0,4}};
        int[][] arr4 = new int[][] {{1,1,1,1},{1,9,10,1},{0,1,1,1},{1,1,1,1}};
        long t = System.currentTimeMillis();
        int res1 = numSubmatrixSumTarget(arr1, 0);
        int res2 = numSubmatrixSumTarget(arr2, 0);
        int res3 = numSubmatrixSumTarget(arr3, 0);
        int res4 = numSubmatrixSumTarget(arr4, 19);
        System.out.println(res1);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - t);
    }
}