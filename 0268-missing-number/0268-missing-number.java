class Solution {
    public int missingNumber(int[] nums) {
        int ans =0;
        int temp =1;
        for(int i:nums){
            ans = ans ^ i;
            ans =ans ^ temp;
            temp++;
        }
        return ans;
    }
}