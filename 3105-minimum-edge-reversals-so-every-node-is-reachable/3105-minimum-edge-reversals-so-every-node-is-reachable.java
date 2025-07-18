class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        // Build adjacency list with direction:
        // (neighbor, 0) for original direction
        // (neighbor, 1) for reverse direction (needs reversal to reach)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(new int[]{v, 0}); // u → v: original direction, no reversal needed from u
            adj.get(v).add(new int[]{u, 1}); // v → u: would need reversal to go from v to u
        }

        int[] result = new int[n];

        // Step 1: calculate total reversals from root (node 0)
        result[0] = dfsCountReversals(0, -1, adj);

        // Step 2: propagate reversal counts to other nodes
        dfsPropagate(0, -1, result, adj);

        return result;
    }

    // DFS to calculate reversal cost from root
    private int dfsCountReversals(int node, int parent, List<List<int[]>> adj) {
        int reversals = 0;
        for (int[] nei : adj.get(node)) {
            int child = nei[0], cost = nei[1];
            if (child == parent) continue;
            reversals += cost + dfsCountReversals(child, node, adj);
        }
        return reversals;
    }

    // DFS to propagate reversal counts to other nodes
    private void dfsPropagate(int node, int parent, int[] result, List<List<int[]>> adj) {
        for (int[] nei : adj.get(node)) {
            int child = nei[0], cost = nei[1];
            if (child == parent) continue;

            // If edge is original (node → child), child needs one more reversal
            // If edge is reversed (node ← child), child needs one less reversal
            result[child] = result[node] + (cost == 0 ? 1 : -1);

            dfsPropagate(child, node, result, adj);
        }
    }
}
