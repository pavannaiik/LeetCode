class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[100001];
        for(int num:nums){
            if(num < 0) num = -1*num;
            arr[num]++;
        }
        int n = nums.length;
        int[] result = new int[n];
        int k=0;
        for(int i=0;i<100001;i++){
            if(arr[i] <=0) continue;
            while(arr[i]-- >0){
                result[k++]=(i)*(i);
            }
        }
        return result;
    }
}