/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
import java.util.*;
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        Deque<Integer> path = new ArrayDeque<>();
        combinationSum2(candidates, target, path, 0);
        System.out.println("输出 => " + res);
        return res;
    }

    public void combinationSum2(int[] candidates, int target, Deque<Integer> path, int begin) {
        for (int i = begin; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i-1]) {
                System.out.println("continue");
                continue;
            }
            path.addLast(candidates[i]);
            if (newTarget == 0) {
                res.add(new ArrayList<>(path));
            }
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]) + ", bengin = " + begin);
            combinationSum2(candidates, newTarget, path, i+1);
            path.removeLast();
            System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i])+ ", bengin = " + begin);
        }


//        for (int j = 0; j < candidates.length; j++) {
//            path.addLast(candidates[j]);
//            System.out.println("target "+ target + " candidates[j] " + candidates[j]);
//            if (target < candidates[j]) {
//                path.removeLast();
//                return;
//            }
//            if (target == candidates[j]) {
//                ArrayList<Integer> pathList = new ArrayList<>(path);
//                System.out.println("输出path => " + path);
//                res.add(new ArrayList<>(path));
//                for (int i=0; i < pathList.size(); i++) {
//                    HashSet<Integer> pathSet = new HashSet<Integer>();
//                    for (int k=0; k < pathList.size(); k++) {
//                        if (i != k ) {
//                            pathSet.add(pathList.get(k));
//                        }
//                    }
//                    HashSet<Integer> lastPathSet = pathMap.get(pathList.get(i));
//                    if (lastPathSet!= null) {
//                        pathSet.addAll(lastPathSet);
//                    }
//                    pathMap.put(pathList.get(i), pathSet);
//                }
//                break;
//            }
//            HashSet lastPathSet = pathMap.get(path.peekLast());
//            if (lastPathSet != null && lastPathSet.contains(candidates[0])) {
//                continue;
//            }
//            ArrayList<Integer> newCandidates = new ArrayList<>();
//            for(int i = j+1; i < candidates.length; i++) {
//                newCandidates.add(candidates[i]);
//            }
//            // System.out.println("target " + target + "candidates[j] " + candidates[j]);
//            int newTarget = target - candidates[j];
//            int[] newCandidatesArray = new int[newCandidates.size()];
//            for (int i = 0; i <newCandidates.size(); i++) {
//                newCandidatesArray[i] = newCandidates.get(i);
//            }
//            System.out.println("====================================");
//            System.out.println("newCandidatesArray " + Arrays.toString(newCandidatesArray));
//            System.out.println("newTarget " + newTarget);
//            System.out.println("newPath " + path);
//            if (newTarget < newCandidatesArray[0]) {
//                path.removeLast();
//                break;
//            }
//            combinationSum2(newCandidatesArray, newTarget, path);
//        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        // int[] candidates = new int[] {2,5,2,1,2};
        int target = 8;
        solution.combinationSum2(candidates, target);
    }
}