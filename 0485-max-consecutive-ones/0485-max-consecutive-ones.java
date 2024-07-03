class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int maxHere=0;
        for(int n:nums){
           max=Math.max(max,maxHere=n==0?0:maxHere+1);
        }
        return max;
    }
}