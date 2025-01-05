class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Pair<Integer, Integer>>queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int flag=1;
        for(int i=0;i< n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) freshOranges++;
                if(grid[i][j]==2 ){
                    queue.add(new Pair(i,j));
                }
            }
        }
        if(freshOranges==0) return 0;
        int minTime=0;
        while(!queue.isEmpty()){
            minTime++;
            int len = queue.size();
            for(int k=0;k<len;k++){
                Pair node = queue.poll();
                int x = (int)node.getKey();
                int y= (int)node.getValue();
                if(freshOranges==0) return minTime-1;
                for(int i=0;i<4;i++){
                    int r= x+dir[i][0];
                    int c = y+dir[i][1];
                    if(r >=0 && r <n && c >=0 && c < m && grid[r][c]==1){
                        freshOranges--;
                        grid[r][c]=2;
                        queue.add(new Pair(r,c));
                    }
                }
            }
            

        }
        return freshOranges==0?minTime-1:-1;
    }
}