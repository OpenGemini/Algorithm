/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * 示例 1：
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 *
 * 实例2：
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
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
    public int minCameraCover(TreeNode root) {
        System.out.println(root.toString());
        return 0;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {0,0,null,0,null,0,null,null,0};
        Solution solution = new Solution();
        TreeNode root = solution.dfsCreateTreeNode(nums, 0);
        root.dfsPrint(root);
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