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
    public class pair{
        int h;
        int d;

        public pair(int h, int d){
            this.h = h;
            this.d = d;
        }
    }

    public pair dia(TreeNode root){
        if(root==null){
            return new pair(0,0);
        }
        pair l = dia(root.left);
        pair r = dia(root.right);
        pair p = new pair(0,0);

        p.h = Math.max(l.h,r.h)+1;
        p.d = Math.max(l.h+r.h, Math.max(l.d, r.d));

        return p;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        return dia(root).d;
    }
}