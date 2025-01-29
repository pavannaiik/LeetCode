class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i+1]=i+1;
        }
        for(int[] edge:edges){
           int p1 = findParent(edge[0], parent);
           int p2 = findParent(edge[1], parent);
           if(p1!=p2){
            parent[p2]=p1;
           }else{
            return edge;
           }
        }
        return new int[]{};
    }
    public int findParent(int x, int[] parent){
        return parent[x]==x?x:findParent(parent[x], parent);
    }
}