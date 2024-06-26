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
    public TreeNode bstToGst(TreeNode root) {
       DFS(root, 0);
       return root;
    }
    public int DFS(TreeNode node, int base){
        if(node==null){
            return base;
        }
        int rightSum = DFS(node.right,base);
        node.val += rightSum;
        int leftSum = DFS(node.left, node.val);
        return leftSum;
    }
}