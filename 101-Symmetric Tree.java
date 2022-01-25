/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkIsSymmetric(root, root);
    }

    public static boolean checkIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        return (left.val == right.val) && checkIsSymmetric(left.left, right.right)
                    && checkIsSymmetric(left.right, right.left);
    }
}