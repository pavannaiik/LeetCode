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
 // O(n) + O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer>result = new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode cur = queue.poll();
                if(i==len-1){
                    result.add(cur.val);
                }
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
        }
        return result;

    }
}