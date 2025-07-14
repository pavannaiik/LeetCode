class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i=0;i<len;i+=2){
            if(i != len-1 && flowerbed[i+1]==1){
                i++;
            }else if(flowerbed[i]==0){
                n--;
                if(n==0) return true;
            }
        }
        return n<=0;
    }
}