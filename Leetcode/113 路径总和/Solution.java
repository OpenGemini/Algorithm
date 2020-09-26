/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 *               5
 *             / \
 *            4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * 
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, 0, path);
        return resList;
    }

    public void dfs(TreeNode root, int sum, int lastSum, List<Integer> path) {
        List<Integer> newPath = new ArrayList<>(path);
        if (root != null) {
            lastSum += root.val;
            newPath.add(root.val);
        } else {
            return;
        }
        if (root.left == null && root.right == null && lastSum == sum) {
            resList.add(newPath);
        }
        if (root.left != null) {
            dfs(root.left, sum, lastSum, newPath);
        }
        if (root.right != null) {
            dfs(root.right, sum, lastSum, newPath);
        }
    }
}