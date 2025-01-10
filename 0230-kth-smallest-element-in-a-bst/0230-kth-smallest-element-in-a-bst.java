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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
       Stack<TreeNode>stack = new Stack<>();
       int cnt=0;
       while(root!=null || !stack.isEmpty()){
        while(root!=null){
            stack.add(root);
            root=root.left;
        }
        root = stack.pop();
        cnt++;
        if(cnt==k) return root.val;
        root= root.right;
       }
       return 0;
    }
}