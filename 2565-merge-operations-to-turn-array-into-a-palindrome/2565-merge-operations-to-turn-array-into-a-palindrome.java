class Solution {
    public int minimumOperations(int[] nums) {
        int count =0;
        int n = nums.length;
        int left=nums[0], right = nums[n-1];
        for(int i=0, j= n-1; i<j;){
            if(left==right){
                i++;
                j--;
                left = nums[i];
                right=nums[j];
            }else if (left < right){
                i++;
                count++;
                left+=nums[i];
            }else if(left > right){
                j--;
                right+=nums[j];
                count++;
            }
        }
        return count;

    }
}