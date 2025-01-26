class Solution {
    int ans =0;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<heights.length-1;i++){
            int climb = heights[i+1]-heights[i];
            if(climb <= 0){
                continue;
            }
            pq.add(climb);
            bricks-=climb;
            if(bricks < 0 && ladders==0){
                return i;
            }
            if(bricks <0){
                bricks+=pq.poll();
                ladders--;
            }

        }
        return heights.length-1;
    }
}