class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);
        for(int[] edge: edges){
            int x = getParent(parent, edge[0]);
            int y = getParent(parent, edge[1]);
            if(x == y){
                return edge;
            }
            parent[y]= x;
        }
        return new int[]{0,0};
    }
    public int getParent(int[] parent, int i){
        if(parent[i]==-1) return i;
        return parent[i]=getParent(parent, parent[i]);
    }
}