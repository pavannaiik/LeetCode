class Solution {
    public int maximumScore(int[] nums, int k) {
        int res = nums[k], i =k,j=k,n =nums.length,min = nums[k];
        while(i >0 || j < n-1){
            if( i == 0){
                j++;
            }else if( j==n-1){
                i--;
            }else if(nums[i-1] < nums[j+1]){
                j++;
            }else{
                i--;
            }
            min = Math.min(min, Math.min(nums[i],nums[j]));
            res = Math.max(res, min*(j-i+1));
        }
        return res;
    }
}