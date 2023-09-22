class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int max =1;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,dfs(i,j,matrix,cache));
            }
        }
        return max;
    }
    public int dfs(int i,int j,int[][] matrix,int[][] cache){
        
        if(cache[i][j]!=0) return cache[i][j];
        for(int[] d: dirs){
            int x = i+d[0], y = j+d[1];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[i][j]<matrix[x][y]){
               cache[i][j] = Math.max(cache[i][j], dfs(x,y,matrix,cache));
            }
            
        }
        return ++cache[i][j];
        
    }
}