/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.right.val = 2;
        TreeNode lastNode = new TreeNode();
        lastNode.val = 3;
        tree.right.left = lastNode;
        List<Integer> list = solution.inorderTraversal(tree);
        System.out.println(list.toString());
    }
}