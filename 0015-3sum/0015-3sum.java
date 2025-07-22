class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums, 0, 0, nums.length, 3);
    }
    public List<List<Integer>> kSum(int[] nums, int index, int target, int n, int k){
        List<List<Integer>> answer = new ArrayList<>();
        if(index >= n){
            return answer;
        }
        if(k==2){
            int i = index, j = n-1;
            while(i < j){
                if(nums[i]+nums[j] == target){
                    List<Integer>newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[j]);
                    answer.add(newList);
                    while(i < n-1 && nums[i]==nums[i+1]) i++;
                    while(j >0 && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }else if(nums[i]+nums[j] < target){
                    i++;
                }else{
                    j--;
                }
            }
        }else{
            for(int i= index;i<n-k+1;i++){
                List<List<Integer>>cur = kSum(nums, i+1, target-nums[i], n, k-1);
                if(cur!=null){
                    for(List<Integer>list: cur){
                        list.add(0, nums[i]);
                    }
                    answer.addAll(cur);
                }
                
                while(i < n-1 && nums[i]==nums[i+1]) i++;
            }
        }
        return answer;
    }
}