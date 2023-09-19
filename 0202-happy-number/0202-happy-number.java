class Solution {
    HashSet<Integer>set = new HashSet<>();
    public boolean isHappy(int n) {
        while(n!=1){
            n = sumOfsquaresOfN(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        if(n==1) return true;
        return false;
    }
    public int sumOfsquaresOfN(int n){
        int sum =0;
        while(n!=0){
            sum = sum + (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
}