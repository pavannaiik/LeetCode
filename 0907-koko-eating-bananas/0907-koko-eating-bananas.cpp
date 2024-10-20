class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int maxi=INT_MIN;
        int ans = INT_MAX;
        for(int n:piles){
            maxi=max(maxi,n);
        }
        int low=1, high=maxi;
        while(low<high){
            int mid=low+(high-low)/2;
            if( hoursToEat(piles, mid,h) <= h){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return high;
    }
    int hoursToEat(vector<int>& piles,int mid_val,int hours){
        int totalHoursNeeded = 0;
        for(int pile : piles){
            if(pile % mid_val !=0)
                totalHoursNeeded += (pile/mid_val + 1);
            else 
                totalHoursNeeded += (pile/mid_val);
        }
        return totalHoursNeeded;
    }
};