class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if(root == null){
        return new ArrayList<List<Integer>>();
       } 
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> level = new LinkedList<>();
        LinkedList<TreeNode> que_order = new LinkedList<>();
        boolean is_left = true;

        que_order.addLast(root);
        que_order.addLast(null);
        while(!que_order.isEmpty()){
            TreeNode curr = que_order.pollFirst();
            if(curr != null){
                if(is_left){
                    level.addLast(curr.val);
                }
                else{
                    level.addFirst(curr.val);
                }
                if(curr.left != null) que_order.addLast(curr.left);
                if(curr.right != null) que_order.addLast(curr.right);
            }
            else{
                result.add(level);
                level = new LinkedList<Integer>();
                if(!que_order.isEmpty()){
                    que_order.addLast(null);
                }
                is_left = !is_left;
            }
        }
        return result;
    }
}