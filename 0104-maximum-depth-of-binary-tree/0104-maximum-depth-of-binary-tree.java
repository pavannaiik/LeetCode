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
    int res=0;
    public int maxDepth(TreeNode root) {
       if(root==null){
           return 0;
       }
       int level =0;
        Queue<TreeNode>queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            level++;
        }
        return level;
        
    }
}