class Solution {
    public int findTheWinner(int n, int k) {
        return my(n,k)+1;
    }
    public int my(int n,int k){
        if(n==1) return 0;
        return (my(n-1,k)+k)%n;
    }
}