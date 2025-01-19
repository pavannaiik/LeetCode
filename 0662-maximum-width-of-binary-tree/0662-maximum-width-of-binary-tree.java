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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode, Integer>>queue=new LinkedList<>();
        queue.add(new Pair<>(root,0));
        int ans = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            int start = queue.peek().getValue(); // Start position of the level
            int end = start;
            for(int i=0;i<len;i++){
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node =pair.getKey();
                int pos = pair.getValue();
                end = pos;
                if(node.left!=null)  queue.add(new Pair<>(node.left,2*pos));
                if(node.right!=null)  queue.add(new Pair<>(node.right,2*pos+1));
                
            }
            ans = Math.max(ans, end-start+1);
        }

        return ans;
    }
}