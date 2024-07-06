class Solution {
    public int passThePillow(int n, int time) {
        int t = time%(n-1);
        int k = time/(n-1);
        if(k%2==0){
            return 1+t;
        }else{
            return n-t;
        }
    }
}