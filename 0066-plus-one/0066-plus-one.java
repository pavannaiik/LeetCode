class Solution {
    public int[] plusOne(int[] digits) {
        int carry =1;
        int sum=0;
        Deque<Integer>queue = new ArrayDeque<>();
        for(int i=digits.length-1;i>=0;i--){
            sum = carry + digits[i];
            if(sum>9){
                carry = sum/10;
            }else{
                carry =0;
            }
            queue.offer(sum%10);  
        }
        if(carry ==1) queue.offer(1);
        int[] res = new int[queue.size()];
        int i=0;
        while(!queue.isEmpty()){
            res[i++]=queue.removeLast();
        }
        return res;
    }
    
}