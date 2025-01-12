class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, m = board[0].length;
        int len = n*m;
        //row = (n- board[i][j]/m )
        //col = ((j -1)-baord[i][j]%m)
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        boolean[] visited = new boolean[n*m];
        visited[0]=true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int square = cur[0];
            int moves = cur[1];
            for(int i=1;i<=6;i++){
                int nextCell = square+i;
                int[] coordinates = getPosition(nextCell,n);
                int r = coordinates[0];
                int c = coordinates[1];
                if(board[r][c]!=-1){
                    nextCell = board[r][c];
                }
                if(nextCell==n*m) return moves+1;
                if(visited[nextCell-1]==false){
                    visited[nextCell-1]=true;
                    queue.add(new int[]{nextCell,moves+1});
                }
            }
        }
        return -1;
        
    }
    public int[] getPosition(int cell, int n){
        int row = (cell-1)/n;
        int col = (cell-1)%n;
        if(row%2==1){
            col = n-1-col;
        }
        return new int[]{n-1-row, col};

    }
}
