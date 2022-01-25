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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 使用抑或符号，两种情况都走下面的判断，1、p空，q不空  2、p不空，q空
        if (p == null ^ q == null) {
            return false;
        }

        // 两者都为空
        if (p == null && q == null) {
            return true;
        }

        // 两者都不为空，开始递归比较具体的值了
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}