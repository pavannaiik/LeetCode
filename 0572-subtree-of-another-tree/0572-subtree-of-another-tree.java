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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot, subRoot);      
    }

    private boolean helper(TreeNode r1, TreeNode r2, TreeNode sub) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        boolean flag = false;
        if (r1.val == r2.val) {
            flag = helper(r1.left, r2.left, r2) && helper(r1.right, r2.right, r2);
        }
        return flag || helper(r1.left, sub, sub) || helper(r1.right, sub, sub);
    }
}