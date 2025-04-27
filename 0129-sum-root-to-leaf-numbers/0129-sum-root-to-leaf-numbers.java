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
    int sum =0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
         rootToLeafSum(root, 0);
         return sum;
    }
    private void rootToLeafSum(TreeNode node , int curSum){
        if(node == null){
            return ;
        }
        curSum  = curSum*10 + node.val;
        if(node.left==null && node.right==null){
            sum += curSum;
            curSum = (curSum-node.val)/10;
            return;
        }
        rootToLeafSum(node.left, curSum);
        rootToLeafSum(node.right, curSum);

        curSum = (curSum-node.val)/10;
        return;
    }
}