/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 
 *     3
 *   / \
 *  9  20
 *     /  \
 *    15   7
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
    HashMap<Integer, Integer> inorderMap = new HashMap<Integer,Integer>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode();
        for (int i=0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        post = postorder;
        root = buildNode(0, inorder.length - 1, 0, postorder.length -1);
        return root;
    }

    public TreeNode buildNode(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }
        int nodeVal = post[postorderEnd];
        int index = inorderMap.get(nodeVal);
        TreeNode node = new TreeNode(nodeVal);
        node.left = buildNode(inorderStart, index - 1, postorderStart, postorderStart + index - inorderStart - 1);
        node.right = buildNode(index+1, inorderEnd, postorderStart + index - inorderStart, postorderEnd - 1);
        return node;
    }
}