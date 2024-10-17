class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int maxDigitIndex = -1 , swap1Idx=-1, swap2Idx=-1;
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            if(maxDigitIndex ==-1 || digits[i] > digits[maxDigitIndex] ){
                maxDigitIndex =i;
            }else if( digits[i] < digits[maxDigitIndex]){
                swap1Idx =i;
                swap2Idx =maxDigitIndex;
            }
        }
        if(swap1Idx !=-1 && swap2Idx !=-1){
            char temp = digits[swap1Idx];
            digits[swap1Idx]=digits[swap2Idx];
            digits[swap2Idx]=temp;
        }
        return Integer.parseInt(new String(digits));
    }
}