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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>>result = new ArrayList<>();
        if(root==null) return result;
        HashMap<Integer, List<Integer>>map = new HashMap<>();
        Queue<Pair<Integer, TreeNode>>queue = new LinkedList<>();
        queue.add(new Pair<Integer,TreeNode>(0, root));
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Pair<Integer,TreeNode>p = queue.poll();
                int level = p.getKey();
                TreeNode node = p.getValue();
                if(!map.containsKey(level)){
                    map.put(level, new ArrayList<>());
                }
                map.get(level).add(node.val);
                minVal = Math.min(level, minVal);
                maxVal = Math.max(level, maxVal);
                if(node.left!=null){
                    queue.add(new Pair<Integer,TreeNode>(level-1, node.left));
                }
                if(node.right!=null){
                    queue.add(new Pair<Integer,TreeNode>(level+1, node.right));
                }
            }
        }
        for(int i=minVal;i<=maxVal;i++){
            List<Integer>cur = map.get(i);
            //Collections.sort(cur);
            result.add(cur);
        }
        return result;
    }
}