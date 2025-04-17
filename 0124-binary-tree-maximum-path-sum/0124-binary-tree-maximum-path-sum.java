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
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumMethod(root);
        return maxPathSum;
    }
    public int maxPathSumMethod(TreeNode root){
        if(root==null) return 0;
        int left = maxPathSumMethod(root.left);
        int right = maxPathSumMethod(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        maxPathSum = Math.max(maxPathSum, left+right+root.val);
        return root.val + Math.max(left, right);
    }
}