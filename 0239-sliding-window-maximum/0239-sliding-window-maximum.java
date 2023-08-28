class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>deque=new ArrayDeque<>();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        list.add(nums[deque.peekFirst()]);
        
        for(int i=k;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peekFirst()==i-k)
                deque.pollFirst(); //remove out of window element
             while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
            list.add(nums[deque.peekFirst()]);
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}