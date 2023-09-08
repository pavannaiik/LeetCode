class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dr ={0,0,1,-1};
        int[] dc ={1,-1,0,0};
        int count_fresh=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    count_fresh++;
                }
            }
        }
        if(count_fresh==0) return 0;
        int min=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            min++;
            for(int i=0;i<size;i++){
                int[] curPoint = queue.poll();
                int row = curPoint[0];
                int col = curPoint[1];
                for(int p =0;p<4;p++){
                        if(row+dr[p] <0 || row+dr[p] >= grid.length || col+dc[p] <0 ||col+dc[p] >= grid[0].length || grid[row+dr[p]][col+dc[p]]!=1 ){
                            continue;
                        }
                        grid[row+dr[p]][col+dc[p]]=2;
                        queue.offer(new int[]{row+dr[p],col+dc[p]});
                        count_fresh--;
                }
            }
            
        }
        
        return count_fresh !=0? -1:min-1;
    }
}