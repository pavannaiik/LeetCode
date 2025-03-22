class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer>stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            
            prev[i]= stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            next[i]= stack.isEmpty()?n-i:stack.peek()-i;
            stack.push(i);
        }
        long ans =0;
        for(int i=0;i<n;i++){
            ans += (long)arr[i] * next[i] * prev[i];
            ans = ans%1000000007;
        }
        return (int)ans;
    }
}

