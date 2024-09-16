class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int num : data) {
            count += num;
        }

        int left = 0, sum = 0;
        for (int right = 0; right < count; right++) {
            sum += data[right];
        }

        int ans = count - sum;
        for (int right = count; right < data.length; right++) {
            sum += data[right];
            sum -= data[left++];
            ans = Math.min(ans, count - sum);
        }

        return ans;

    }
}