class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair<Integer,Integer>>queue = new LinkedList<>();
        int n = rooms.length, m = rooms[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j]==0){
                    queue.add(new Pair(i,j));
                }
            }
        }
        if(queue.size()==0) return;
        int dist=1;
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int j=0;j<len;j++){
                Pair cell = queue.poll();
                for(int i=0;i<4;i++){
                int r = (int)cell.getKey() + dir[i][0];
                int c = (int)cell.getValue() + dir[i][1];
                if(r >=0 && r < n && c >=0 && c< m && (rooms[r][c]!=-1 && rooms[r][c] > dist)){
                    queue.add(new Pair(r,c));
                    rooms[r][c]=dist;
                }
            }
            }
            dist++;
        }

    }
}