/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */

import java.util.*;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>(new ArrayList<>()));
        for (int i = 0; i < nums.length; i++) {
            Deque<Integer> path = new ArrayDeque<>();
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            this.subsets(nums, i+1, path);
        }

        return res;
    }

    public void subsets(int[] nums, int begin, Deque<Integer> path) {
        for (int j = begin; j < nums.length; j++) {
            path.addLast(nums[j]);
            res.add(new ArrayList<>(path));
            subsets(nums, j+1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3,4};
        Solution solution = new Solution();
        List<List<Integer>> resList = solution.subsets(nums);
        System.out.println(resList);
    }
}