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
    int diameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestDia(root);
        return diameter;
    }
    public int longestDia(TreeNode root){
        if(root==null) return 0;
        int leftPath = longestDia(root.left);
        int rightPath = longestDia(root.right);
        diameter = Math.max(diameter, leftPath+rightPath);
        return Math.max(leftPath, rightPath)+1;
    }
}