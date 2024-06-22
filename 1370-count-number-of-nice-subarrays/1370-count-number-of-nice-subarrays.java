class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    private int atMost(int[] nums, int k){
        int ans =0;
        int start =0;
        int odds =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                odds++;
            }
            if(odds > k){
                while(odds>k){
                    if(nums[start]%2==1){
                        odds--;
                    }
                    start++;
                }
            }
            ans+= i-start+1;
        }
        return ans;
    }
}