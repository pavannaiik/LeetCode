class Solution {
    public int minimumOperations(int[] nums) {
        int[] count = new int[101];
        Arrays.fill(count,0);
        for(int i=nums.length-1;i>=0;i--){
            if(++count[nums[i]]>1)
            return (int)Math.ceil((double)(i+1)/3);
        }
        return 0;
    }
}