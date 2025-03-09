class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer>result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Collections.binarySearch(result, nums[i]);
            if(index < 0){
                index = -index - 1;
            }
            if(index < result.size()){
                result.set(index, nums[i]);
            }else{
                result.add(nums[i]);
            }
            
        }
        return result.size();
    }
}