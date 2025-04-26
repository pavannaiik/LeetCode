class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return getThreeSum(nums, 0, 3, n, 0);
    }
    private List<List<Integer>> getThreeSum(int[] nums, int index, int k, int length, int sum){
        List<List<Integer>>result = new ArrayList<>();
        if(index >= length){
            return result;
        }
        if(k==2){
            int i= index, j = length-1;
            while(i < j){
                if(nums[i]+nums[j] == sum){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                    i++;
                    j--;
                    while(i < length-1 && nums[i] == nums[i-1]){
                        i++;
                    }
                    while(j > 0 && nums[j] == nums[j+1]){
                        j--;
                    }
                }else if(nums[i]+nums[j] > sum){
                    j--;
                }else{
                    i++;
                }
            }

        }else{
            for(int i=index;i<length-k+1;i++){
                List<List<Integer>>ans = getThreeSum(nums, i+1, k-1, length, sum-nums[i]);
                System.out.println(ans);
                if(ans != null){
                    for(List<Integer>lis : ans){
                        lis.add(0, nums[i]);
                    }
                    result.addAll(ans);
                    while(i < length-1 && nums[i] == nums[i+1]){
                        i++;
                    }
                }
                
            }
        }
        return result;
    }
}