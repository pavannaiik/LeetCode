class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer>minDeque = new LinkedList<>();
        Deque<Integer>maxDeque = new LinkedList<>();
        int left = 0;
        int maxLength = 0;
        int n = nums.length;
        for(int right = 0; right<n; right++){
            while(!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            while(!minDeque.isEmpty() && minDeque.peekLast() >nums[right]){
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);
            while(maxDeque.peekFirst()- minDeque.peekFirst() > limit){
                if(maxDeque.peekFirst() == nums[left]){
                    maxDeque.pollFirst();
                }
                if(minDeque.peekFirst()== nums[left]){
                    minDeque.pollFirst();
                }
                ++left;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}