/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode>parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      List<Integer>ans=new ArrayList<>();
      if(root==null) return ans;
      buildParentMap(root, null);

      Queue<TreeNode>queue = new LinkedList<>();
      Set<TreeNode>visited = new HashSet<>();
      queue.add(target);
      visited.add(target);
      int dist=0;
      while(!queue.isEmpty()){
        if(dist==k){
            for(TreeNode node:queue){
                ans.add(node.val);
            }
            return ans;
        }
        int len = queue.size();
        for(int i=0;i<len;i++){
            TreeNode node = queue.poll();
            if(node.left!=null && !visited.contains(node.left)){
                queue.add(node.left);
                visited.add(node.left);
            }
            if(node.right!=null && !visited.contains(node.right)){
                queue.add(node.right);
                visited.add(node.right);
            }
            if(parentMap.get(node) !=null && !visited.contains(parentMap.get(node))){
                queue.add(parentMap.get(node));
                visited.add(parentMap.get(node));
            }
        }
        dist++;
      }
      return ans;

    }
    public void buildParentMap(TreeNode child, TreeNode parent){
        if(child==null){
            return;
        }
        parentMap.put(child, parent);
        buildParentMap(child.left, child);
        buildParentMap(child.right, child);
    }
}