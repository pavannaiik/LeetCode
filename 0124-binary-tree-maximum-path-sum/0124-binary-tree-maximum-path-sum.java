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
    int maxV = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxV;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        leftSum = Math.max(0, leftSum);
        rightSum = Math.max(0, rightSum);
        maxV = Math.max(maxV, root.val+leftSum+rightSum);
        return root.val+Math.max(leftSum, rightSum);
    }
}