class Solution {
    public int sumOfDigitsSquared(int n){
        int sum =0;
        int m = n;
        while(m!=0){
            int d = m%10;
            sum = sum + d*d;
            m=m/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
       
       int slow = sumOfDigitsSquared(n);
       int fast = sumOfDigitsSquared(sumOfDigitsSquared(n));
       while(slow!=fast && fast!=1){
        slow = sumOfDigitsSquared(slow);
        fast = sumOfDigitsSquared(sumOfDigitsSquared(fast));
       }
       if(fast == 1) return true;
       return false;

    }
}