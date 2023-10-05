class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n =nums.length;
        int c =0;
        for(int i:nums){
            if(i==target) c++;
        }
        return c > n/2;
    }
}