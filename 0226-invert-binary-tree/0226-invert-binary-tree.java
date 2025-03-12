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
    public TreeNode invertTree(TreeNode root) {
         invertBTree(root);
         return root;
    }
    public void  invertBTree(TreeNode root){
        if(root == null){
            return ;
        }
        TreeNode temp =  root.left;
        root.left = root.right;
        root.right = temp;
        invertBTree(root.left);
        invertBTree(root.right);
        return;
    }
}