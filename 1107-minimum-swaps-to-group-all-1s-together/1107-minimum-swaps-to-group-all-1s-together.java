class Solution {
    public int minSwaps(int[] data) {
        long ones =0;
        ones = Arrays.stream(data).filter(num->num==1).count();
        int left =0, right = 0;
        int n = data.length;
        int sum =0;
        int maxSum =0;
        while(right < n){
            sum += data[right];
            right++;
            if(right-left > ones){
                sum -= data[left];
                left++;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return (int)ones - maxSum;

    }
}