class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int mul = 10;
        int tempX = x;
        int revX = 0;
        while(tempX !=0){
            revX = revX * mul + tempX%10;
            tempX = tempX/10;
        }
        return x == revX;
    }
}