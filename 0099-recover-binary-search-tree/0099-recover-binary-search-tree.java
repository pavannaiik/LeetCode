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
    
    TreeNode x = null, y = null, prev = null;
    public void recoverTree(TreeNode root) {
    inorder(root);
       if(x != null && y != null){
         int temp = x.val;
         x.val = y.val;
         y.val = temp;
       }

    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev != null && root.val < prev.val){
            y = root;
            if(x==null) x = prev;
        }
        prev = root;
        inorder(root.right);
    }
}