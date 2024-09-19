class Solution {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        for(int i=primeOne*primeTwo;i>0;i--){
            if(!canBeFormed(primeOne,primeTwo,i)){
                return i;
            }
        }
        return 1;
    }
    public boolean canBeFormed(int p1, int p2, int n){
        for(int i=0;i<= n/p1;i++){
            int remainder = n- p1*i;
            if(remainder %p2==0) return true;
        }
        return false;
    }
}