/**
 * Solution 1：由于BST是一个左边<右边的数据结构，所以可以将其转变成一个ArrayList有序的数组，
 * 然后接着就像 167-Two Sum II - Input array is sorted 操作就可以，就是多一层树转成ArrayList的过程
 *
 * Solution 2：通过HashSet来存放树中的节点数据，然后使用（k-当前节点的val）看结果在不在HashSet中，若在就返回true
 * 不在，就加入到集合中，然后左右子树递归上面的操作
 *
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        treeToArray(root, list);

        for (int i = 0, j = list.size()-1; i < j; ) {
            if (list.get(i) + list.get(j) == k) {
                return true;
            } else if (list.get(i) + list.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void treeToArray(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        treeToArray(root.left, list);
        list.add(root.val);
        treeToArray(root.right, list);
    }

    /** Solution 2
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
     */
}
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