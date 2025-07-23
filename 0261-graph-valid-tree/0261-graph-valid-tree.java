class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // Rule: tree must have exactly n - 1 edges

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            if (x == y) return false; // Cycle detected

            parent[x] = y; // Union
        }

        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return parent[i] = find(parent, parent[i]); // Path compression
    }
}
