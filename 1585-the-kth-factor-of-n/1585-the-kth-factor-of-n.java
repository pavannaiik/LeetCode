class Solution {
    public int kthFactor(int n, int k) {
        List<Integer>factors = new ArrayList<>();
        int sqrtN = (int) Math.sqrt(n);
        for(int i=1;i<=sqrtN;i++){
            if(n%i==0){
                k--;
                factors.add(0,n/i);
                if(k==0) return i;
            }
        }
        if(sqrtN*sqrtN ==n) k++;
        return k<=factors.size()?factors.get(k-1):-1;

    }
}