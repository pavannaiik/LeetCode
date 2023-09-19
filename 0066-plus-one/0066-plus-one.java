class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0 ;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        //if the program arrived till this point means the we need to add 1 to the start of array
        digits = new int[digits.length+1];
            digits[0]=1;
        return digits;
    }
    
}