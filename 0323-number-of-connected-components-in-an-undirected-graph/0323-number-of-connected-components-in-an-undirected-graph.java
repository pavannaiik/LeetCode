class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int components=n;
        for(int[] edge: edges){
            int x = getParent(parent, edge[0]);
            int y = getParent(parent, edge[1]);
            if(x!=y){
                components--;
                parent[y]= x;
            }
        }
        return components;
    }
    public int getParent(int[] parent, int i){
        if(parent[i] == -1){
            return i;
        }
        return parent[i]=getParent(parent, parent[i]);
    }
}