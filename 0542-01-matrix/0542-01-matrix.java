class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] delRows = {0,0,1,-1};
        int[] delCols = {1,-1,0,0};
        Queue<int[]>queue = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1){
                   mat[i][j] = Integer.MAX_VALUE;
                }else{
                   queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] curCell = queue.poll();
            for(int i=0;i<4;i++){
                int r = curCell[0] + delRows[i];
                int c = curCell[1] + delCols[i];
                if( r <0 || r >= rows || c <0 || c >= cols || mat[r][c] <= mat[curCell[0]][curCell[1]]+1){
                    continue;
                }
                mat[r][c] = mat[curCell[0]][curCell[1]]+1;
                queue.add(new int[]{r,c});
            }
        }

        return mat;
    }
}
