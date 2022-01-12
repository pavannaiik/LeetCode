class Solution {
    //Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        //Arrays.sort(nums);
        //return nums[nums.length/2];
        int count=0;
        Integer num=null;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                num=nums[i];
            }
            if(nums[i]==num)
                count++;
            else count --;
        }
        return num;
    }
}