class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length-k+1];
        ArrayDeque<Integer>arrDQ = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!arrDQ.isEmpty() && nums[arrDQ.peekLast()]<nums[i]){
                arrDQ.pollLast();
            }
            arrDQ.add(i);
        }
        int j=0;
        arr[j++]=nums[arrDQ.peekFirst()];
        for(int i=k;i<nums.length;i++){
            while(!arrDQ.isEmpty() && (i-arrDQ.peekFirst() )>= k ){
                arrDQ.pollFirst();
            }
            while(!arrDQ.isEmpty() && nums[arrDQ.peekLast()] < nums[i]){
                arrDQ.pollLast();
            }
            arrDQ.add(i);
            arr[j++]=nums[arrDQ.peekFirst()];
        }
        return arr;
    }
}