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
    public int goodNodes(TreeNode root) {
        return dfs(root.val , root) ; 

    }
    private int  dfs ( int  currMax  ,  TreeNode node){
        int numGoodNodes = 0;
        if(node!=null){
            if(node.val>=currMax){
                currMax = node.val ; 
                numGoodNodes ++ ; 
            } 
            numGoodNodes += dfs(currMax , node.left) ; 
            numGoodNodes += dfs(currMax , node.right) ;
         
        }
        return  numGoodNodes ; 
    }
}