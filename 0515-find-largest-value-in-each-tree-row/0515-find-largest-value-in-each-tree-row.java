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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            int max = queue.peek().val;
            for(int i=0;i<len;i++){
                TreeNode node = queue.poll();
                max = Math.max(max,node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                
                }
                if(node.right!=null){
                    queue.offer(node.right);

                }
            }
            list.add(max);
        }
        return list;
    }
}