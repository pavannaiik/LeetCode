class Solution {
    public int sumSubarrayMins(int[] arr) {
       int MOD = 1_000_000_007;
        int n = arr.length;

        // Arrays to store left and right bounds
        int[] prev = new int[n];
        int[] next = new int[n];

        // Monotonic stack to calculate prev
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        // Clear the stack for reuse
        stack.clear();

        // Monotonic stack to calculate next
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Calculate the result
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) arr[i] * prev[i] * next[i];
            result %= MOD;
        }

        return (int) result;    
    }
}