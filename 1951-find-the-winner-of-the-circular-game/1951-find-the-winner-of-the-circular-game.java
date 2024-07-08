class Solution {
    public int findTheWinner(int n, int k) {
       HashSet<Integer>set = new HashSet<>();
       for(int i=1;i<=n;i++){
        set.add(i);
       }
       int t=1;
       int i=1;
       while(i%n <= n){
        if(set.size()==1){
            break;
        }
        if((i%n==0 && set.contains(n)) || set.contains(i%n)){
            if(t==k){
                if(i%n==0)
                set.remove(n);
                else set.remove(i%n);
                t=1;
            }else{
                t++;
            }
        }
            i++;
       }
       int ans =0;
       for(int p:set){
        ans =p;
        break;
       }
       return ans;
    }
}