class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for(int num:nums){
            maxVal = Math.max(maxVal, num);
        }
        int[] freqCount = new int[n+maxVal];
        for(int num:nums){
            freqCount[num]++;
        }
        int minIncrement =0;
        for(int i=0;i< freqCount.length;i++){
            if(freqCount[i]<=1) continue;
            int duplicates = freqCount[i]-1;
            freqCount[i+1]+=duplicates;
            freqCount[i]=1;
            minIncrement+=duplicates;
        }
        return minIncrement;
    }
}