class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provience=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                provience++;
            }
        }
        return provience;
    }
    public void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city]=true;
        for(int i=0;i<isConnected[0].length;i++){
            if(!visited[i] && isConnected[city][i]==1){
                dfs(isConnected, visited, i);
            }
        }
    }
}