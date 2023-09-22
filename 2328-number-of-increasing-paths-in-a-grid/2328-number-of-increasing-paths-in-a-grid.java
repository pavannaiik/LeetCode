class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int mod = 1000000007;
    public int countPaths(int[][] matrix) {
        int max =0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = (max % mod +dfs(i,j,matrix,cache)%mod)%mod;
            }
        }
        return max%mod;
    }
    public int dfs(int i,int j,int[][] matrix,int[][] cache){
        
        int res=1;
        if(cache[i][j]!=0) return cache[i][j];
        for(int[] d: dirs){
            int x = i+d[0], y = j+d[1];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[i][j]<matrix[x][y]){
               res = (res%mod + dfs(x,y,matrix,cache)%mod)%mod;
            }
            
        }
        return cache[i][j]=res;
        
    }
}
        
       