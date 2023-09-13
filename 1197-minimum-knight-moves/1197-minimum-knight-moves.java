class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[] drow = {-2,-2,-1,-1, 1,1, 2,2};
        int[] dcol = {-1, 1,-2, 2,-2,2,-1,1};
        int ans =0;
        Set<String>set = new HashSet<String>();
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        set.add("0,0");
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int[] temp = queue.poll();
                int row = temp[0];
                int col = temp[1];
                if(row==x && col ==y){
                    return ans;
                }
                for(int j=0;j<8;j++){
                    int nrow = row+drow[j];
                    int ncol = col+dcol[j];
                    if(!set.contains(nrow+","+ncol) && nrow >= -1 && ncol >= -1){
                       set.add(nrow+","+ncol);
                      queue.offer(new int[]{nrow,ncol});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}