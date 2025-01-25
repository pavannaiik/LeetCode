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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // A map to store column -> List of (row, value) pairs
        TreeMap<Integer, List<int[]>> columnMap = new TreeMap<>();

        // BFS queue storing nodes along with their row and column
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0}); // {node, row, column}

        // Perform BFS
        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            TreeNode node = (TreeNode) current[0];
            int row = (int) current[1];
            int col = (int) current[2];

            // Add the node to the corresponding column list
            columnMap.putIfAbsent(col, new ArrayList<>());
            columnMap.get(col).add(new int[]{row, node.val});

            // Add the left and right children with updated row and column
            if (node.left != null) {
                queue.offer(new Object[]{node.left, row + 1, col - 1});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }

        // Prepare the result list
        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> nodes : columnMap.values()) {
            // Sort the nodes by row, and if row is the same, by value
            Collections.sort(nodes, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1]; // Sort by value if row is the same
                }
                return a[0] - b[0]; // Sort by row
            });

            // Extract the values for the column
            List<Integer> columnValues = new ArrayList<>();
            for (int[] node : nodes) {
                columnValues.add(node[1]);
            }
            result.add(columnValues);
        }

        return result;

    }
}