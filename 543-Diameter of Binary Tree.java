class Solution {
    // 记录目前路径最长的长度
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        diameter = Math.max(diameter, left + right);
        // 返回某节点的左右两子树最长的长度，并向上递归返回 +1
        return Math.max(left, right) + 1;
    }
}