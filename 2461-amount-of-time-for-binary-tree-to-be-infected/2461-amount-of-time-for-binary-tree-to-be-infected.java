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
    Map<Integer, List<Integer>>map = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        Queue<Integer>queue = new LinkedList<>();
        buildMap(root, null);
        queue.add(start);
        Set<Integer>visited = new HashSet<>();
        int ans =0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int node = queue.poll();
                if(!visited.contains(node)){
                    for(int child:map.get(node)){
                    if(!visited.contains(child))
                     queue.add(child);
                 }
                }
                visited.add(node);
            }
            ans++;
        }
        return ans-1;
    }
    public void buildMap(TreeNode root, TreeNode parent){
        if(root==null) return;
        if(!map.containsKey(root.val)){
            map.put(root.val, new ArrayList<>());
        }
        if(parent!=null)
        map.get(root.val).add(parent.val);
        if(root.left!=null)
        map.get(root.val).add(root.left.val);
        if(root.right!=null)
        map.get(root.val).add(root.right.val);
        buildMap(root.left, root);
        buildMap(root.right, root);
    }
}