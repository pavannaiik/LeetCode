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
    public int[] findMode(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        if(root == null) return new int[0];
        HashMap<Integer,Integer>map = new HashMap<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i =0;i<len;i++){
                TreeNode node = queue.poll();
                map.put(node.val,map.getOrDefault(node.val,0)+1);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int val:map.values()){
            max = Math.max(max,val);
        }
        for(int key:map.keySet()){
            if(map.get(key)==max){
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
}