class Solution {
    public long dividePlayers(int[] skill) {
        int sum = Arrays.stream(skill).sum();
        int n = skill.length;
        int req = (sum*2)/n;
        if(sum%2!=0 && (n/2)%2==0) return -1;
        Arrays.sort(skill);
        long ans=0;
        int i=0, j= n-1;
        while(i<j){
            if(skill[i]+skill[j]!=req){
                return -1;
            }
            ans+=(skill[i]*skill[j]);
            i++;
            j--;
        }
        return ans;
    }
}