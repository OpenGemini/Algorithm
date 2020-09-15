/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * Constraints:
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * Each element of candidate is unique.
 * 1 <= target <= 500
 */
import java.util.*;
class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = sectionSum(candidates, target, candidates.length - 1);
        System.out.println("输出 => " + res);
        return res;
    }

    public static List<List<Integer>> sectionSum(int[] candidates, int target, int start) {
        List<List<Integer>> resList = new ArrayList<>();
        System.out.print("start " + start + "\n");
        for(int i = start; i >= 0; i--) {
            if (candidates[i] > target) continue;
            System.out.print("target " + target + ", i " + candidates[i] + "\n");
            if (target%candidates[i] == 0) {
                List<Integer> itemList = new ArrayList<>();
                int num = target / candidates[i];
                for (int j = 0; j < num; j++)
                    itemList.add(candidates[i]);
                resList.add(itemList);
            }
            if (i == 0) return resList;
            start = i-1;
            int newTarget = target - candidates[i];
            for (int j=2; newTarget > 0; j++) {
                List<List<Integer>> loopRes = sectionSum(candidates, newTarget, start);
                for (List<Integer> loopItemRes : loopRes) {
                    for (int k = j; k > 1; k--) {
                        loopItemRes.add(candidates[i]);
                    }
                    resList.add(loopItemRes);
                }
                newTarget = target - j*candidates[i];
            }
        }
        return resList;
    }

    public static void main(String args[]) {
        int[] example = new int[] {2,3,5};
        combinationSum(example, 8);
    }
}