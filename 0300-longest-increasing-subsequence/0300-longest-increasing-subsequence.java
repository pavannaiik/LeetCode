class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer>result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i] > result.get(result.size()-1)){
                result.add(nums[i]);
            }else{
                int index = binarySearch(result, nums[i]);
                result.set(index, nums[i]);
            }
        }
        return result.size();
    }
    public int binarySearch(List<Integer> result, int target){
        int low = 0, high = result.size()-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(result.get(mid) == target){
                return mid;
            }else if(result.get(mid) > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;

    }
}