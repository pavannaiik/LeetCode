class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int left=0;
        long sum =0;
        long ans=0;
        HashSet<Integer>set= new HashSet<>();
        for(int i=0;i<n;i++){
            while(left < i && set.contains(nums[i])){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            while(i-left+1 > k){
                sum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[i]);
            sum += nums[i];
            if(i-left+1==k){
                ans=Math.max(ans, sum);
            }
        }
        return ans;
    }
}