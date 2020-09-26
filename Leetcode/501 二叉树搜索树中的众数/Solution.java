/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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
    int count = 0;
    int max = 0;
    int last = -999;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        countTree(root);
        int [] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void countTree(TreeNode root) {
        if (root == null) {
            return;
        }
        countTree(root.left);
        if (root.val == last) {
            count++;
        } else {
            last = root.val;
            count = 1;
        }
        System.out.println("========");
        System.out.println("上一个数: "+ last +", 现在的数: " + root.val + ", 当前count: " + count + ", max为: " + max);
        if (count > max) {
            max = count;
            list.clear();
        }
        if (count >= max && !list.contains(root.val)) {
            list.add(root.val);
        }
        System.out.println("========");
        countTree(root.right);
    }

    public static void main(String[] args) {
        // {1,2} => 1,2
        // {} => []
        // {1,null,2,null,null,2} => 2
        // {1,1,2} => 1
        // {1,null,2} => 1,2
        Integer[] nums = new Integer[] {1,null,2};
        Solution solution = new Solution();
        TreeNode tree = solution.dfsCreateTreeNode(nums, 0);
        int[] res = solution.findMode(tree);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
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