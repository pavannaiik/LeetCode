class Solution {
    int res=0;
    List<List<Integer>>adj = new ArrayList<>();
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
    }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs( 0,-1 , values, k);
        return res;
    }
    public long dfs(int node, int parent, int[] values, int k){
        long totalSum = values[node];
        for(int neighbor:adj.get(node)){
            if(neighbor != parent){
                totalSum += (dfs(neighbor, node, values, k));
            }
        }
        if(totalSum % k==0){
            res += 1;
            return 0;
        }
        return totalSum;
    }
}