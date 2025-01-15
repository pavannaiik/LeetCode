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
    private HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null ) return 0;
        // Check if the result for this node is already calculated
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int robCurrent = root.val;
        if(root.left!=null){
            robCurrent += rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
             robCurrent += rob(root.right.left)+rob(root.right.right);
        }
        int skipCurrent = rob(root.left)+rob(root.right);
        // Take the maximum of both cases
        int result = Math.max(robCurrent, skipCurrent);
        // Store the result in the memo map
        memo.put(root, result);
        return result;
    }
}