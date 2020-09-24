/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {1,3,2,5};
        Integer[] nums2 = new Integer[] {2,1,3,null,4,null,7};
        Solution solution = new Solution();
        TreeNode tree1 = solution.dfsCreateTreeNode(nums, 0);
        TreeNode tree2 = solution.dfsCreateTreeNode(nums2, 0);
        TreeNode tree3 = solution.mergeTrees(tree1, tree2);
        tree3.dfsPrint(tree3);
    }

    public TreeNode dfsCreateTreeNode(Integer[] nums, int begin) {
        TreeNode node = new TreeNode();
        if (begin > nums.length-1 || nums[begin] == null) {
            return null;
        }
        if (nums[begin] != null) {
            node.val = (int) nums[begin];
            node.left = dfsCreateTreeNode(nums, 2*(begin+1)-1);
            node.right = dfsCreateTreeNode(nums, 2*(begin+1));
        }
        return node;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public void dfsPrint(TreeNode node) {
            System.out.println(node.val);
            if (node.left != null) {
                dfsPrint(node.left);
            }
            if (node.right != null) {
                dfsPrint(node.right);
            }
        }
    }
}