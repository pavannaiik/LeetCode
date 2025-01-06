class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pro = 1;
        int zero = 0;
        for(int i =0 ;i < nums.length; i++)
        {
           if(nums[i]!=0)
            pro = pro * nums[i];          
            else
            zero++;
        }
        int[] res = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            if(nums[i]!=0 && zero==0)
                res[i] = pro/nums[i];
            else if((zero>=1) && nums[i]!=0)
                        res[i]=0;
            else if (zero==1 && nums[i]==0)
                res[i] = pro;

            }
            return res;
        }
}