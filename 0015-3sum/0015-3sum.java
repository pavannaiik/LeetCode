class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return getKSum(nums, 0, 0, 3);
    }
    public List<List<Integer>> getKSum(int[] nums, int index, int target, int k){
        List<List<Integer>> answer = new ArrayList<>();
        if(index >= nums.length){
         return answer;
        }
        if(k==2){
           int left = index, right = nums.length-1;
           while(left < right){
             if(nums[left]+nums[right] == target){
             List<Integer>tempList = new ArrayList<>();
             tempList.add(nums[left]);
             tempList.add(nums[right]);
             answer.add(tempList);
             while(left<nums.length-1 && nums[left] == nums[left+1]) left++;
             while(right>0 && nums[right]==nums[right-1]) right--;
             left++;
             right--;
             }else if(nums[left]+nums[right] > target){
             right--;
             }else{
             left++;
             }
           }
        }else{
           for(int i=index; i< nums.length-k+1;i++){
                List<List<Integer>>curList = getKSum(nums, i+1, target-nums[i], k-1);
                for(List<Integer>list: curList){
                 list.add(0, nums[i]);
                }
                answer.addAll(curList);
                while(i<nums.length-1 && nums[i] == nums[i+1]) i++;

           }
        }
        return answer;
    }
}