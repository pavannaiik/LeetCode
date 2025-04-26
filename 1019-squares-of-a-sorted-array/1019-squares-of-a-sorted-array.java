class Solution {
    public int[] sortedSquares(int[] nums) {
        int maxVal = nums[0];
        for(int num:nums){
            if(num <0) num=-1*num;
            maxVal = Math.max(maxVal, num);
        }
        int[] arr = new int[maxVal+1];
        for(int num:nums){
            if(num < 0) num = -1*num;
            arr[num]++;
        }
        int n = nums.length;
        int[] result = new int[n];
        int k=0;
        for(int i=0;i<=maxVal;i++){
            if(arr[i] <=0) continue;
            while(arr[i]-- >0){
                result[k++]=(i)*(i);
            }
        }
        return result;
    }
}