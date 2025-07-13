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
        if(root == null) return new ArrayList<>();
        List<List<Integer>>answer = new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        boolean even = true;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer>curList = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                if(even){
                    curList.add(cur.val);
                }else{
                    curList.addFirst(cur.val);
                }
            }
            answer.add(curList);
            even = !even;

        }
        return answer;
    }
}