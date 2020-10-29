/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] { hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    // public int findSurplus(int[] nums, int surplus, int begin) {
    //     int end = nums.length - 1;
    //     int mid;
    //     while (begin < end) {
    //         mid = begin + end >> 1;
    //         if (nums[mid] < surplus) {
    //             begin = mid + 1;
    //         } else if (nums[mid] > surplus) {
    //             end = mid;
    //         } else if (nums[mid] == surplus) {
    //             return mid;
    //         }
    //     }
    //     return -1;
    // }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15, 5, 8 ,9 ,3, 17};
        int target = 20;
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, target);
        for (int r : res) {
            System.out.println(r);
        }
    }
}