class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight =0;
        int maxWeight=0;
        for(int weight:weights){
            maxWeight = Math.max(maxWeight, weight);
            totalWeight+=weight;
        }
        int low = maxWeight, high = totalWeight;
        while(low<high){
            int mid = low + (high-low)/2;
            if(canShip(weights, mid, days)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;

    }
    public boolean canShip(int[] weights, int maxWeight, int days){
        int requiredDays=1;
        int totalWeight =0;
        for(int weight:weights){
            totalWeight+=weight;
            if(totalWeight >maxWeight){
                requiredDays++;
                totalWeight=weight;
            }
        }
       
        return requiredDays<=days;
    }
}