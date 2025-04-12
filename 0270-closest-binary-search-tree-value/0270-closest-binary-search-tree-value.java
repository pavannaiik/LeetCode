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
    double closestValue = Double.MAX_VALUE;
    int val = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        getClosest(root, target);
        return val;
    }
    public void getClosest(TreeNode root, double target){
        if(root==null) return;
        double diff = (double)(root.val) - target;
       // closestValue = Math.min(closestValue, Math.abs(diff));
        if(closestValue > Math.abs(diff)){
            closestValue = Math.abs(diff);
            val = root.val;
        }
        if(closestValue == Math.abs(diff)){
            val = Math.min(val, root.val);
        }
        if(diff > 0){
            getClosest(root.left, target);
        }else{
            getClosest(root.right, target);
        }
    }
}