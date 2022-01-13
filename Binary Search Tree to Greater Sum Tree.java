class Solution {
    public TreeNode bstToGst(TreeNode root) {
        DFS(root,0);
        return root;
    }
    public int DFS(TreeNode node,int base){
       if(node==null)
           return base;
        int rightSum=DFS(node.right,base); //find right sum
        node.val=rightSum+node.val; //add right sum to cur sum
        int leftSum=DFS(node.left,node.val); //find left sum and 
        return leftSum;
    }
}