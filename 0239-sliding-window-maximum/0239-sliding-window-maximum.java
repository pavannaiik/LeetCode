class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq = new ArrayDeque<>();
        List<Integer>ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        ans.add(nums[dq.peek()]);
        for(int i=k;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k){
                dq.pollFirst();
            }
             while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            ans.add(nums[dq.peekFirst()]);
        }
        return ans.stream().mapToInt(a->a).toArray();

    }
}