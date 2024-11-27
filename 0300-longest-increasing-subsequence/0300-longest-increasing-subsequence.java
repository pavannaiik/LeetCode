class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS,1);
        int max =1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                LIS[i]=Math.max(LIS[i],LIS[j]+1);
            }
            max = Math.max(max,LIS[i]);
        }
        return max;
    }
}