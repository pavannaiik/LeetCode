class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
       int max = Arrays.stream(piles).max().getAsInt();
        int low=1;
        while(low < max){
            int mid=low+(max-low)/2;
            if(checkSpeed(piles,mid,h)<=h){
                max=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int checkSpeed(int[] piles,int mid_val,int hours){
        int totalHoursNeeded = 0;
        for(int pile : piles){
            if(pile % mid_val !=0)
                totalHoursNeeded += (pile/mid_val + 1);
            else 
                totalHoursNeeded += (pile/mid_val);
        }
        return totalHoursNeeded;
    }
}