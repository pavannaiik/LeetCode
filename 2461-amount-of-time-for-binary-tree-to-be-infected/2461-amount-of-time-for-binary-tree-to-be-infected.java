class Solution {
    int amount =0;
    public int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return amount;
    }
    private int traverse(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left, start);
        int right = traverse(root.right, start);
        if (root.val == start) {
            amount = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        } else {
            amount = Math.max(amount, Math.abs(left - right));
            return Math.min(left, right) - 1;
        }
    }
}
   