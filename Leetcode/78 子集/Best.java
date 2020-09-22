/**
 * 思路:
 * 用二进制表示,比如数组[1,2,3],1表示4的位置.2表示2的位置,1表示1的位置.
 * 所以所有的组合有:
 * 二进制 组合 十进制表示
 * 000 []       0
 * 100 [1]      4
 * 010 [2]      2
 * 001 [3]      1
 * 110 [1,2]    6
 * 101 [1,3]    5
 * 011 [2,3]    3
 * 111 [1,2,3]  7
 * 所以一共有2^n个组合
 */

import java.util.*;
public class Best {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        // 循环2的n次方遍
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            // mask & (1 << i)做位运算
            // 二进制表示1的都加入到数组,比如5&1为1,5&2为0
            // 101 & 001 = 001, 101 & 010 = 000
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> resList = solution.subsets(nums);
        System.out.println(resList);
    }
}
