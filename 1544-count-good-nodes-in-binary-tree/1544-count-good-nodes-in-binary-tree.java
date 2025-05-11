class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }
    private void dfs(TreeNode root, int maxVal) {
        if(root == null) return ;
        if(root.val == maxVal){
            count++;
        }
        if(root.left != null){
            dfs(root.left, Math.max(maxVal, root.left.val));
        }
        if(root.right != null) {
            dfs(root.right, Math.max(maxVal, root.right.val));
        }
    }
}