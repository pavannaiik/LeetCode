class Solution {
    public int minimizeXor(int num1, int num2) {
        int num2BitCount=Integer.bitCount(num2);
        int num1BitCount=Integer.bitCount(num1);
        if(num1BitCount==num2BitCount) return num1;
        int result = num1;
        int resultBitCount = num1BitCount;
        if(resultBitCount < num2BitCount){
            //we need to increase num1bitcounts
            int bitDiff = num2BitCount-resultBitCount;
            for(int i=0;i<32 && bitDiff>0 ;i++){
                if((result&(1<<i))==0){
                    result = result|(1<<i);
                    bitDiff--;
                }
            }
        }else{
            //we need to decrease num1bitcounts
            int bitDiff = num2BitCount-resultBitCount;
            for(int i=0;i<32 && bitDiff<0 ;i++){
                if((result&(1<<i))!=0){
                    result = result&~(1 << i);
                    bitDiff++;
                }
            }
        }
        return result;
    }
}