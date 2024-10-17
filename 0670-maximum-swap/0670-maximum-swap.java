class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] lastOccurance = new int[10];
        for(int i=0;i<digits.length;i++){
            lastOccurance[digits[i]-'0']=i;
        }
        for(int i=0;i<digits.length;i++){
            for(int d=9;d>digits[i]-'0';d--){
                if(lastOccurance[d] > i ){
                    char temp = digits[i];
                    digits[i] = digits[lastOccurance[d]];
                    digits[lastOccurance[d]] = temp;
                    // Return the result as an integer
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}