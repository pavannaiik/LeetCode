class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>deque = new ArrayDeque<>();
        List<Integer>ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans.add(nums[deque.peekFirst()]);
        for(int i=k;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peek()==i-k){
                deque.pollFirst();
            }
             while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            ans.add(nums[deque.peekFirst()]);
        }
        return ans.stream().mapToInt(a->a).toArray();
    }
}