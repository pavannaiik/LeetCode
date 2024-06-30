class Solution {
    int len =0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums,target, 4,0);
    }
    public ArrayList<List<Integer>> kSum(int[] nums,long target, int K, int index ){
        ArrayList<List<Integer>>ans = new ArrayList<>();
        if(index >= len){
            return ans;
        }
        if(K==2){
            int i = index, j= len-1;
            while(i < j){
                long sum = (long) nums[i]+nums[j];
                if(sum==target){
                    List<Integer>list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ans.add(list);
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j]==nums[j-1])j--;
                    i++;
                    j--;
                }else if(sum < target){
                    i++;
                }else{
                    j--;
                }
            }

        }else{
            for(int i=index;i<nums.length-K+1;i++){
                ArrayList<List<Integer>>res = kSum(nums, target-nums[i], K-1, i+1);
                if(res!=null){
                    for(List<Integer>temp:res){
                        temp.add(0, nums[i]);
                    }
                    ans.addAll(res);
                }
                while(i<len-1 && nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
        return ans;
    }
}