/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * } */
import java.util.*;
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        System.out.println(res.toString());
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {1,null,2,null,null,3};
        Solution solution = new Solution();
        TreeNode tree = solution.dfsCreateTreeNode(nums, 0);
        solution.dfsPrint(tree);
        solution.postorderTraversal(tree);
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

    public void dfsPrint(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null) {
            return;
        }
        list.add(root);
        while (list.size()>0) {
            TreeNode node = list.pop();
            if (node == null) {
                continue;
            }
            System.out.print(node.val + " ");
            list.add(node.left);
            list.add(node.right);
        }
    }
}