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
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        List<List<Integer>>output=new ArrayList<>();
        Queue<MyClass>queue = new LinkedList<>();
        if(root==null) return output;

        queue.offer(new MyClass(root,0));
        int min =0, max =0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                MyClass myclass = queue.poll();
                if(myclass.node!=null){
                    if(!map.containsKey(myclass.level)){
                        map.put(myclass.level,new ArrayList<>());
                    }
                    map.get(myclass.level).add(myclass.node.val);
                }
                min = Math.min(myclass.level,min);
                max = Math.max(myclass.level,max);
                if(myclass.node.left!=null){
                    queue.offer(new MyClass(myclass.node.left,myclass.level-1));
                }
                if(myclass.node.right!=null){
                    queue.offer(new MyClass(myclass.node.right,myclass.level+1));
                }
            }
        }
        
        for(int k=min;k<=max;k++){
            output.add(map.get(k));
        }
        return output;


    }
}
class MyClass{
    TreeNode node;
    int level;
    MyClass(TreeNode node,int level){
        this.node = node;
        this.level=level;
    }
}