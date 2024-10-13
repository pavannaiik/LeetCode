class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        int maxVal=Arrays.stream(nums).max().getAsInt();
        int minVal = Arrays.stream(nums).min().getAsInt();
        if(minVal==maxVal) return 0;
        int bucketSize = (int) Math.ceil((double)(maxVal-minVal)/(n-1));
        int[] minBucket = new int[n];
        int[] maxBucket = new int[n];
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for(int x:nums){
            int idx = (x-minVal)/bucketSize;
            minBucket[idx]=Math.min(x,minBucket[idx]);
            maxBucket[idx]=Math.max(x,maxBucket[idx]);
        }
        int maxGap = bucketSize;
        int prev = maxBucket[0];
        for(int i=1;i<n;i++){
            if(minBucket[i]==Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i]-prev);
            prev = maxBucket[i];
        }
        return maxGap;
        

    }
}