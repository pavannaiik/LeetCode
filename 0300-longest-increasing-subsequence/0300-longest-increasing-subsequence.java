class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int pos=0,cur=0;
         dp[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>dp[pos])
              dp[++pos]=nums[i];
             else
             {
                 cur=pos;
                 while(cur>=0 && dp[cur]>=nums[i])
                 cur--;
                 dp[cur+1]=nums[i];
             } 
        }

        return pos+1;
    
        
    }
}