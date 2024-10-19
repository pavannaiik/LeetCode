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
    private int maxSum =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int leftPathSum = dfs(root.left);
        int rightPathSum = dfs(root.right);
        leftPathSum = Math.max(0,leftPathSum);
        rightPathSum = Math.max(0,rightPathSum);
        maxSum = Math.max(maxSum, root.val+leftPathSum+rightPathSum);
        return root.val + Math.max(leftPathSum,rightPathSum);
    }
}