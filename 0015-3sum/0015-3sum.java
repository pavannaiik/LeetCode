class Solution {
    List<List<Integer>>ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return kSum(nums, 0,n,3, 0);
        
    }
    public List<List<Integer>> kSum(int[] nums, int index, int n, int k, long target){
        List<List<Integer>>ans = new ArrayList<>();
        if(index>=n){
            return ans;
        }
        if(k==2){
            int i=index, j= n-1;
            while( i < j){
                long curSum =nums[i]+nums[j];
                if(curSum==target){
                    List<Integer>curList= new ArrayList<>();
                    curList.add(nums[i]);
                    curList.add(nums[j]);
                    ans.add(curList);
                    while(i<n-1 && nums[i]==nums[i+1])i++;
                    while(j>0 && nums[j]==nums[j-1]) j--;
                    i++;
                    j--;

                }else if( curSum > target){
                    j--;
                }else{
                    i++;
                }
            }
        }else{
                for(int i=index;i<n-k+1;i++){
                    List<List<Integer>>list = kSum(nums, i+1, n, k-1, target-nums[i]);
                    if(list!=null){
                        for(List<Integer>presentList:list){
                          presentList.add(0, nums[i]);
                       }
                    ans.addAll(list);
                    while(i<n-1 && nums[i]==nums[i+1])i++;
                    }
                }
            }
            return ans;
    }
}