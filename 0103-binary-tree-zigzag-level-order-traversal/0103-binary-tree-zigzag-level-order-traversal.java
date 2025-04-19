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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode>queue= new LinkedList<>();
        List<List<Integer>>answer= new ArrayList<>();
        if(root==null){
            return answer;
        }
        answer.add(Arrays.asList(root.val));
        queue.add(root);
        int level =1;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer>temp = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null){
                    queue.add(cur.left);
                    temp.add(cur.left.val);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                    temp.add(cur.right.val);
                }
            }
            if(level%2!=0){
                Collections.reverse(temp);
            }
            level++;
            if(temp.size()!=0){
                answer.add(temp);
            }
            
        }
        return answer;
        
    }
}