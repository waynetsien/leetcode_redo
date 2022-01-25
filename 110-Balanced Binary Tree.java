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
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    // 以某个节点为例，都有一个对象Info，其中有isBalanced是否平衡，还有该节点所在树中的高度height
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    // 具体处理逻辑，构造当前节点的Info信息
    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        // 此处+1是为了算当前节点在树中的高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced &&
                Math.abs(leftInfo.height - rightInfo.height) < 2;

        return new Info(isBalanced, height);
    }
}