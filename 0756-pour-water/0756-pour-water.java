class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        int cur = k;
        int n = heights.length;
        for(int i=0; i < volume;i++){
            //go all the way left 
            while( cur >0 && heights[cur]>=heights[cur-1]){
                cur--;
            }
            //go all the way to right
            while(cur < n-1 && heights[cur]>= heights[cur+1]){
                cur++;
            }
            //come at k index
            while(cur > k && heights[cur]==heights[cur-1]){
                cur--;
            }
            heights[cur]+=1;
        }
        return heights;
    }
}