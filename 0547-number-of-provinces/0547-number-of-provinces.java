class Solution {
    Set<Integer>set = new HashSet<>();
    public int findCircleNum(int[][] isConnected) {
        int cnt =0;
        for(int i=0;i<isConnected.length;i++){
            if(!set.contains(i)){
                cnt++;
                dfs(isConnected, i);
            }
        }
        return cnt;
    }
    public void dfs(int[][] isConnected, int i){
        set.add(i);
        for(int j=0;j<isConnected.length;j++){
            if(!set.contains(j)  && isConnected[i][j]==1){
                dfs(isConnected, j);
            }
        }
    }
}