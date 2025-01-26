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
    Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap<>();
    int minColumn = 0, maxColumn = 0;

    private void DFS(TreeNode node, Integer row, Integer column) {
        if (node == null) return;

        if (!columnTable.containsKey(column)) {
            columnTable.put(column, new ArrayList<Pair<Integer, Integer>>());
        }

        columnTable.get(column).add(new Pair<>(row, node.val));
        minColumn = Math.min(minColumn, column);
        maxColumn = Math.max(maxColumn, column);

        // Preorder DFS traversal
        DFS(node.left, row + 1, column - 1);
        DFS(node.right, row + 1, column + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        // Step 1: Perform DFS traversal
        DFS(root, 0, 0);

        // Step 2: Retrieve and sort values from the columnTable
        for (int i = minColumn; i <= maxColumn; ++i) {
            Collections.sort(columnTable.get(i), new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    if (p1.getKey().equals(p2.getKey())) {
                        return p1.getValue() - p2.getValue(); // Sort by value if rows are the same
                    } else {
                        return p1.getKey() - p2.getKey(); // Sort by row
                    }
                }
            });

            List<Integer> sortedColumn = new ArrayList<>();
            for (Pair<Integer, Integer> p : columnTable.get(i)) {
                sortedColumn.add(p.getValue());
            }
            output.add(sortedColumn);
        }

        return output;
    }
}