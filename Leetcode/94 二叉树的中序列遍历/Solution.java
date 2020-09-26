/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
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

    public List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()>0) {
            if (root.left!=null) {
                queue.add(root.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        TreeNode lastNode = new TreeNode();
        lastNode.val = 3;

        TreeNode rightNode = new TreeNode();
        rightNode.left = lastNode;
        rightNode.val = 2;

        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.right = rightNode;


        List<Integer> list = solution.inorderTraversal(tree);
        System.out.println(list.toString());
    }
}