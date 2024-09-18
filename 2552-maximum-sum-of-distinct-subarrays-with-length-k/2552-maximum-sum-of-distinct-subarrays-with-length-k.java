class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans =0;
        int left =0;
        long sum = 0;
        int n = nums.length;
        HashSet<Integer>set= new HashSet<>();
        for(int i=0;i<n;i++){
            while(set.contains(nums[i])){
                sum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            while(i-left+1 >k){
                sum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum += nums[i];
            if(i-left+1==k){
                ans =Math.max(ans, sum);
            }
            set.add(nums[i]);
        }
        return ans;
    }
}