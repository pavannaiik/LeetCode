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
        if( root ==null) return true;
        return depth(root)!=-1;
    }
    public int depth(TreeNode root){
        if(root ==null) return 0;
        int leftSize = depth(root.left);
        int rightSize =depth(root.right);
        if(leftSize ==-1 || rightSize == -1 || Math.abs(leftSize-rightSize)>1)
            return -1;
        return 1 + Math.max(leftSize,rightSize);
    }
}