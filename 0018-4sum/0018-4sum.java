class Solution {
    int len;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
        
    }
    public List<List<Integer>> kSum(int [] nums, long target, int k, int index){
        List<List<Integer>>ans = new ArrayList<>();
        if(index >= len){
            return ans;
        }
        if(k==2){
            int i= index, j = len-1;
            while(i < j){
                long sum = nums[i]+nums[j];
                if(sum == target){
                    List<Integer>list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ans.add(list);
                    while( i < len-1 && nums[i]==nums[i+1]) i++;
                    while(j >0 && nums[j]==nums[j-1])j--;
                    i++;
                    j--;
                }else if(sum>target){
                    j--;
                }else{
                    i++;
                }
            }
        }else{
            
            for(int i=index;i<len-k+1;i++){
                List<List<Integer>>res = kSum(nums, target-nums[i], k-1, i+1);
                if(res!=null){
                    for(List<Integer>list:res){
                        list.add(0, nums[i]);
                    }
                    ans.addAll(res);
                }
                while(i < len-1 && nums[i]==nums[i+1]) i++;
            }
        }
        return ans;
    }
}